package com.example.chen.usercenter.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.example.chen.baselibrary.common.Constant
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.baselibrary.utils.AppPrefsUtils
import com.example.chen.baselibrary.utils.GlideUtils
import com.example.chen.usercenter.R
import com.example.chen.usercenter.data.protocol.UserInfo
import com.example.chen.usercenter.injection.component.DaggerUserComponent
import com.example.chen.usercenter.injection.module.UserModule
import com.example.chen.usercenter.presenter.UserInfoPresenter
import com.example.chen.usercenter.presenter.view.UserInfoView
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.DateUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.user.utils.UserPrefsUtils
import com.qiniu.android.http.ResponseInfo
import com.qiniu.android.storage.UpCompletionHandler
import com.qiniu.android.storage.UploadManager
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import java.io.File

class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView, TakePhoto.TakeResultListener {


    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    private val mUploadManager: UploadManager by lazy { UploadManager() }
    //本地图片路径
    private var mLocalFile: String? = null
    //服务器图片地址
    private var mRemoteFile: String? = null
    //头像
    private var mUserIcon: String? = null
    //用户签名
    private var mUserSign: String? = null
    //用户名
    private var mUserName: String? = null
    //用户性别
    private var mUserGender: String? = null
    private var mUserMobile: String? = null

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        mTakePhoto = TakePhotoImpl(this, this)
        mTakePhoto.onCreate(savedInstanceState)
        initView()
        initData()

    }

    private fun initData() {
        mUserIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
        mUserGender = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
        mUserName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        mUserSign = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_SIGN)
        mUserMobile = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
        mRemoteFile=mUserIcon
        if (mUserIcon != ""){
            GlideUtils.loadUrlImage(this,mUserIcon!!,mUserIconIv)
        }
        mUserNameEt.setText(mUserName)
        mUserMobileTv.text =mUserMobile

        if (mUserGender == "0") {
            mGenderMaleRb.isChecked = true
        }
        else {
            mGenderFemaleRb.isChecked = true
        }

        mUserSignEt.setText(mUserSign)


    }

    private fun initView() {
        mUserIconView.Onclick {
            showAlertView()
        }
        mHeaderBar.getRightView().Onclick {
            mPresenter.editUser(mRemoteFile!!,
                    mUserNameEt.text?.toString()?:"",
                    if(mGenderMaleRb.isChecked) "0" else "1",
                    mUserSignEt.text?.toString()?:""
            )
        }
    }

    private fun showAlertView() {
        AlertView("选择图片", "", "取消", null,
                arrayOf("拍照", "相册"), this, AlertView.Style.ActionSheet, object : OnItemClickListener {
            override fun onItemClick(o: Any?, position: Int) {
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
                when (position) {
                    0 -> {
                        createTempFile()
                        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                    }
                    1 -> mTakePhoto.onPickFromGallery()
                }
            }

        }).show()
    }

    override fun takeSuccess(result: TResult?) {
        //原始地址
        Log.d("TakePhoto", result?.image?.originalPath)
        //压缩后的地址
        Log.d("TakePhoto", result?.image?.compressPath)
        mLocalFile = result?.image?.compressPath
        mPresenter.getUploadToken()
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
            Log.e("TakePhoto", msg)
    }

    fun createTempFile() {
        //时间来命名文件
        val tempFileName = "${DateUtils.curTime}.png"
        //有sd卡
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        //内存
        this.mTempFile = File(filesDir, tempFileName)
    }

    override fun onGetUploadTokenResult(result: String) {
        mUploadManager.put(mLocalFile, null, result, object : UpCompletionHandler {
            override fun complete(key: String?, info: ResponseInfo?, response: JSONObject) {
                mRemoteFile = Constant.IMAGE_SERVER_ADDRESS + response.get("hash")
                GlideUtils.loadImage(this@UserInfoActivity, mRemoteFile!!, mUserIconIv)
            }

        }, null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }
    override fun onEditUserResult(result: UserInfo) {
        toast("修改资料成功")
        UserPrefsUtils.putUserInfo(result)
    }
}

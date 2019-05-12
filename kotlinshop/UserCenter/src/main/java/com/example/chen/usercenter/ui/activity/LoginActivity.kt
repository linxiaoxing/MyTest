package com.example.chen.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.enable
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.baselibrary.utils.AppPrefsUtils
import com.example.chen.provider.PushProvider
import com.example.chen.provider.router.RouterPath
import com.example.chen.usercenter.R
import com.example.chen.usercenter.data.protocol.UserInfo
import com.example.chen.usercenter.injection.component.DaggerUserComponent
import com.example.chen.usercenter.injection.module.UserModule
import com.example.chen.usercenter.presenter.LoginPresenter
import com.example.chen.usercenter.presenter.view.LoginView
import com.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    @Autowired(name = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
    @JvmField
    var mPushProvider: PushProvider? = null

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt, { isBtnEnable() })
        mLoginBtn.enable(mPwdEt, { isBtnEnable() })
        mLoginBtn.setOnClickListener(this)
        mHeaderBar.getRightView().Onclick(this)
        mForgetPwdTv.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),mPushProvider?.getPushId()?:"")
            }
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not()
                && mPwdEt.text.isNullOrEmpty().not()

    }

    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
        startActivity<UserInfoActivity>()
        finish()
    }
}

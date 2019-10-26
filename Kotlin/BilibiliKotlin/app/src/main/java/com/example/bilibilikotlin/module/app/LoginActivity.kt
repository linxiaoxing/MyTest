package com.example.bilibilikotlin.module.app

import android.content.Intent
import android.text.TextUtils
import android.view.View
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.base.BaseActivity
import com.example.bilibilikotlin.constant.Constants
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.utils.PrefsUtils
import com.example.bilibilikotlin.utils.ToastUtils
import com.example.bilibilikotlin.utils.net.NetworkUtils
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.TimeUnit

/**
 * * 描述:登录界面
 */

class LoginActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initWidget() {
        //名称监听
        RxView.focusChanges(et_username)
            .compose(bindToLifecycle())
            .subscribe { aBoolean ->
                if (aBoolean) {
                    if (et_username.text.isNotEmpty()) {
                        visible(delete_username)
                    } else {
                        gone(delete_username)
                    }
                }
                iv_icon_left.setImageResource(R.drawable.ic_22)
                iv_icon_right.setImageResource(R.drawable.ic_33)
            }

        //密码监听
        RxView.focusChanges(et_password)
            .compose(bindToLifecycle())
            .subscribe { aBoolean ->
                if (aBoolean) {
                    iv_icon_left.setImageResource(R.drawable.ic_22_hide)
                    iv_icon_right.setImageResource(R.drawable.ic_33_hide)
                }
            }

        //监听名称变化
        RxTextView.textChangeEvents(et_username)
            .compose<TextViewTextChangeEvent>(bindToLifecycle<TextViewTextChangeEvent>())
            .subscribe { textViewTextChangeEvent ->
                et_password.setText("")
                if (textViewTextChangeEvent.count() > 0) {
                    visible(delete_username)
                } else {
                    gone(delete_username)
                }
            }

        //点击登录监听
        RxView.clicks(btn_login)
            .throttleFirst(5, TimeUnit.SECONDS)//5秒内取第一个事件 防止重复点击发送事件
            .compose(bindToLifecycle<Any>())
            .subscribe {
                val isAvailable = NetworkUtils.isConnected(AppUtils.getAppContext())
                if (!isAvailable) {
                    ToastUtils.showCenterSingleToast("当前网络不可用")
                } else {
                    //登录
                    login()
                }
            }

        //点击删除监听
        RxView.clicks(delete_username)
            .throttleFirst(5, TimeUnit.SECONDS)//5秒内取第一个事件 防止重复
            .compose(bindToLifecycle())
            .subscribe {
                // 清空用户名以及密码
                et_username.setText("")
                et_password.setText("")
                delete_username.visibility = View.GONE
                et_username.isFocusable = true
                et_username.isFocusableInTouchMode = true
                et_username.requestFocus()
            }
    }

    /**
     * 假登录
     */
    private fun login() {
        val name = et_username.text.toString()
        val password = et_password.text.toString()
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showCenterSingleToast("用户名不能为空")
            return
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showCenterSingleToast("密码不能为空")
            return
        }

        PrefsUtils.getInstance().putBoolean(Constants.IS_LOGINED_FLAG, true)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun initToolbar() {
        super.initToolbar()
        mToolbar?.title = "登录"
    }
}
package com.example.wankotlin.ui.activity

import android.view.View
import com.example.wankotlin.R
import com.example.wankotlin.base.BaseMvpActivity
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.event.LoginEvent
import com.example.wankotlin.ext.showToast
import com.example.wankotlin.mvp.contract.RegisterContract
import com.example.wankotlin.mvp.model.bean.LoginData
import com.example.wankotlin.mvp.presenter.RegisterPresenter
import com.example.wankotlin.utils.DialogUtil
import com.example.wankotlin.utils.Preference
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus


class RegisterActivity: BaseMvpActivity<RegisterContract.View, RegisterContract.Presenter>(), RegisterContract.View {

    /**
     * local username
     */
    private var user: String by Preference(Constant.USERNAME_KEY, "")
    /**
     * local password
     */
    private var pwd: String by Preference(Constant.PASSWORD_KEY, "")

    override fun createPresenter(): RegisterContract.Presenter = RegisterPresenter()

    private val mDialog by lazy {
        DialogUtil.getWaitDialog(this, getString(R.string.register_ing))
    }

    override fun showLoading() {
        mDialog.show()
    }

    override fun hideLoading() {
        mDialog.dismiss()
    }

    override fun registerSuccess(data: LoginData) {
        showToast(getString(R.string.register_success))
        isLogin = true
        user = data.username
        pwd = data.password

        EventBus.getDefault().post(LoginEvent(true))
        finish()
    }

    override fun registerFail() {
        isLogin = false
    }

    override fun attachLayoutRes(): Int = R.layout.activity_register

    override fun useEventBus(): Boolean = false

    override fun enableNetworkTip(): Boolean = false

    override fun initData() {
    }

    override fun initView() {
        super.initView()
        btn_register.setOnClickListener(onClickListener)
        tv_sign_in.setOnClickListener(onClickListener)
    }

    override fun start() {
    }

    /**
     * OnClickListener
     */
    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.btn_register -> {
                register()
            }
            R.id.tv_sign_in -> {
            }
        }
    }

    /**
     * Register
     */
    private fun register() {
        if (validate()) {
            mPresenter?.registerWanAndroid(et_username.text.toString(),
                et_password.text.toString(),
                et_password2.text.toString())
        }
    }

    /**
     * check data
     */
    private fun validate(): Boolean {
        var valid = true
        val username: String = et_username.text.toString()
        val password: String = et_password.text.toString()
        val password2: String = et_password2.text.toString()
        if (username.isEmpty()) {
            et_username.error = getString(R.string.username_not_empty)
            valid = false
        }
        if (password.isEmpty()) {
            et_password.error = getString(R.string.password_not_empty)
            valid = false
        }
        if (password2.isEmpty()) {
            et_password2.error = getString(R.string.confirm_password_not_empty)
            valid = false
        }
        if (password != password2) {
            et_password2.error = getString(R.string.password_cannot_match)
            valid = false
        }
        return valid
    }
}
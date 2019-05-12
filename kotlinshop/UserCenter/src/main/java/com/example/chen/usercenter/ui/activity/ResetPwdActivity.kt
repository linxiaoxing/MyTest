package com.example.chen.usercenter.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.enable
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.usercenter.R
import com.example.chen.usercenter.injection.component.DaggerUserComponent
import com.example.chen.usercenter.injection.module.UserModule
import com.example.chen.usercenter.presenter.ResetPwdPwdPresenter
import com.example.chen.usercenter.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.*

class ResetPwdActivity : BaseMvpActivity<ResetPwdPwdPresenter>(), ResetPwdView {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)
        initView()

    }
    private fun initView() {
        mConfirmBtn.enable(mPwdEt,{isBtnEnable()})
        mConfirmBtn.enable(mPwdConfirmEt,{isBtnEnable()})
        mConfirmBtn.Onclick {
            if (mPwdEt.text.toString()!=mPwdConfirmEt.text.toString()){
                toast("密码不一致")
                return@Onclick
            }
            mPresenter.resetPwd(intent.getStringExtra("mobile"),mPwdEt.text.toString())
        }
    }
    override fun onResetPwdResult(result: String) {
        toast("重置密码成功")
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }

    private fun isBtnEnable():Boolean{
        return mPwdEt.text.isNullOrEmpty().not()
                 &&mPwdConfirmEt.text.isNullOrEmpty().not()

    }

}

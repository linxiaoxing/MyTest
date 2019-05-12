package com.example.chen.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.example.chen.baselibrary.ext.enable
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.usercenter.R
import com.example.chen.usercenter.injection.component.DaggerUserComponent
import com.example.chen.usercenter.injection.module.UserModule
import com.example.chen.usercenter.presenter.ForgetPwdPresenter
import com.example.chen.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView ,View.OnClickListener{
    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    }
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()

    }

    private fun initView() {
        mNextBtn.enable(mMobileEt,{isBtnEnable()})
        mNextBtn.enable(mVerifyCodeEt,{isBtnEnable()})
        mVerifyCodeBtn.setOnClickListener(this)
        mNextBtn.setOnClickListener(this)
    }
    override fun onClick(v: View) {
       when(v.id){
           R.id.mVerifyCodeBtn ->{
               mVerifyCodeBtn.requestSendVerifyNumber()
           }
           R.id.mNextBtn->{
               mPresenter.forgetPwd(mMobileEt.text.toString(), mVerifyCodeEt.text.toString());
           }
       }
    }
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not()
                 &&mVerifyCodeEt.text.isNullOrEmpty().not()

    }

}

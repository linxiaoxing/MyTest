package com.example.chen.usercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.chen.usercenter.presenter.view.ForgetPwdView
import com.example.chen.usercenter.presenter.view.RegisterView
import com.example.chen.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {
    @Inject
    lateinit var userServiceImpl: UserServiceImpl;
    fun forgetPwd(mobile: String, verifyCode: String) {
        /**
         * 业务逻辑
         */
        if (!checkNetWork()){
            return
        }

        mView.showLoading()
        userServiceImpl.forgetPwd(mobile, verifyCode)
                .excute(object : BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if (t)
                        mView.onForgetPwdResult("验证成功");
                        mView.hideLoading()
                    }


                },lifecycleProvider )


    }

}
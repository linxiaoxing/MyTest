package com.example.chen.usercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.chen.usercenter.presenter.view.RegisterView
import com.example.chen.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    lateinit var userServiceImpl: UserServiceImpl;
    fun register(mobile: String, pwd: String, verifyCode: String) {
        /**
         * 业务逻辑
         */
        if (!checkNetWork()){
            return
        }

        mView.showLoading()
        userServiceImpl.register(mobile, pwd, verifyCode)
                .excute(object : BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if (t)
                        mView.onRegisterResult("注册成功");
                        mView.hideLoading()
                    }


                },lifecycleProvider )


    }

}
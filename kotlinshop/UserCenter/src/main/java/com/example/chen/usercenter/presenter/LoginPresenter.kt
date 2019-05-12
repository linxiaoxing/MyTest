package com.example.chen.usercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.chen.usercenter.data.protocol.UserInfo
import com.example.chen.usercenter.presenter.view.LoginView
import com.example.chen.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userServiceImpl: UserServiceImpl;
    fun login(mobile: String, pwd: String, pushId: String) {
        /**
         * 业务逻辑
         */
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userServiceImpl.login(mobile, pwd, pushId)
                .excute(object : BaseSubscriber<UserInfo>(mView){
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t);
                        mView.hideLoading()
                    }


                },lifecycleProvider )


    }

}
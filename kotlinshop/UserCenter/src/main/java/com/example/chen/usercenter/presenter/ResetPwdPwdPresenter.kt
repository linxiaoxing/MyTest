package com.example.chen.usercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.chen.usercenter.presenter.view.ForgetPwdView
import com.example.chen.usercenter.presenter.view.RegisterView
import com.example.chen.usercenter.presenter.view.ResetPwdView
import com.example.chen.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class ResetPwdPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {
    @Inject
    lateinit var userServiceImpl: UserServiceImpl;
    fun resetPwd(mobile: String, verifyCode: String) {
        /**
         * 业务逻辑
         */
        if (!checkNetWork()){
            return
        }

        mView.showLoading()
        userServiceImpl.resetPwd(mobile, verifyCode)
                .excute(object : BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if (t)
                        mView.onResetPwdResult("重置密码成功");
                        mView.hideLoading()
                    }


                },lifecycleProvider )


    }

}
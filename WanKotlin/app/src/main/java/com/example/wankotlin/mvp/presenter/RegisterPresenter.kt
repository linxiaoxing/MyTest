package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.base.BasePresenter
import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.RegisterContract
import com.example.wankotlin.mvp.model.RegisterModel

class RegisterPresenter : BasePresenter<RegisterContract.Model, RegisterContract.View>(), RegisterContract.Presenter {

    override fun createModel(): RegisterContract.Model? = RegisterModel()

    override fun registerWanAndroid(username: String, password: String, repassword: String) {
        mModel?.registerWanAndroid(username, password, repassword)?.ss(mModel, mView) {
            mView?.apply {
                if (it.errorCode != 0) {
                    registerFail()
                } else {
                    registerSuccess(it.data)
                }
            }
        }
    }


}
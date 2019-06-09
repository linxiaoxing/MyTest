package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.base.BasePresenter
import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.LoginContract
import com.example.wankotlin.mvp.model.LoginModel

class LoginPresenter : BasePresenter<LoginContract.Model, LoginContract.View>(), LoginContract.Presenter {

    override fun createModel(): LoginContract.Model? = LoginModel()

    override fun loginWanAndroid(username: String, password: String) {
        mModel?.loginWanAndroid(username, password)?.ss(mModel, mView) {
            mView?.loginSuccess(it.data)
        }
    }

}
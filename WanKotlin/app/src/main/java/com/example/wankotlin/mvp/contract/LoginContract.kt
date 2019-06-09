package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.LoginData
import io.reactivex.Observable

interface LoginContract {

    interface View: IView {

        fun loginSuccess(data: LoginData)

        fun loginFail()
    }

    interface Presenter: IPresenter<View> {

        fun loginWanAndroid(username: String, password: String)
    }

    interface Model: IModel {

        fun loginWanAndroid(username: String, password: String): Observable<HttpResult<LoginData>>
    }
}
package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

interface MainContract {

    interface View: IView {
        fun showLogoutSuccess(success: Boolean)
    }

    interface Presenter: IPresenter<View> {
        fun logout()
    }

    interface Model: IModel {
        fun logout(): Observable<HttpResult<Any>>
    }
}
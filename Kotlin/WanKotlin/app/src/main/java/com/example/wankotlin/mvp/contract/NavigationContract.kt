package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.NavigationBean
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/5/13.
 */
interface NavigationContract {

    interface View : IView {
        fun setNavigationData(list: List<NavigationBean>)
    }

    interface Presenter : IPresenter<View> {
        fun requestNavigationList()
    }

    interface Model : IModel {
        fun requestNavigationList(): Observable<HttpResult<List<NavigationBean>>>
    }

}
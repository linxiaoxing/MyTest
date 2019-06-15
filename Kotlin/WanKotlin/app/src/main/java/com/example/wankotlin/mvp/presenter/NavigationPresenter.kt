package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.base.BasePresenter
import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.NavigationContract
import com.example.wankotlin.mvp.model.NavigationModel

class NavigationPresenter : BasePresenter<NavigationContract.Model, NavigationContract.View>(), NavigationContract.Presenter {

    override fun createModel(): NavigationContract.Model? = NavigationModel()

    override fun requestNavigationList() {
        mModel?.requestNavigationList()?.ss(mModel, mView) {
            mView?.setNavigationData(it.data)
        }
    }

}
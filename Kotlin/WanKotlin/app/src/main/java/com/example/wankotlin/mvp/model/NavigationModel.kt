package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.NavigationContract
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.NavigationBean
import io.reactivex.Observable

class NavigationModel : BaseModel(), NavigationContract.Model {

    override fun requestNavigationList(): Observable<HttpResult<List<NavigationBean>>> {
        return RetrofitHelper.service.getNavigationList()
    }

}
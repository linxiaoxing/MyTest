package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.MainContract
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

class MainModel: BaseModel(), MainContract.Model {

    override fun logout(): Observable<HttpResult<Any>> {
        return RetrofitHelper.service.logout()
    }
}
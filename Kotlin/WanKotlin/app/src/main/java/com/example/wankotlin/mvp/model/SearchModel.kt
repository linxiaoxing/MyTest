package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.SearchContract
import com.example.wankotlin.mvp.model.bean.HotSearchBean
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

class SearchModel: BaseModel(), SearchContract.Model {

    override fun getHotSearchData(): Observable<HttpResult<MutableList<HotSearchBean>>> {
        return RetrofitHelper.service.getHotSearchData()
    }
}
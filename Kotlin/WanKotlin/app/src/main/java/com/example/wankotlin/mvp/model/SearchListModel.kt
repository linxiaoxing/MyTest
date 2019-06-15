package com.example.wankotlin.mvp.model

import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.SearchListContract
import com.example.wankotlin.mvp.model.CommonModel
import com.example.wankotlin.mvp.model.bean.ArticleResponseBody
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

class SearchListModel : CommonModel(), SearchListContract.Model {

    override fun queryBySearchKey(page: Int, key: String): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.queryBySearchKey(page, key)
    }

}
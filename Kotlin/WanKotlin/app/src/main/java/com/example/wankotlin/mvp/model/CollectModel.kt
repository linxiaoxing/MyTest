package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.CollectContract
import com.example.wankotlin.mvp.model.bean.CollectionArticle
import com.example.wankotlin.mvp.model.bean.CollectionResponseBody
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

class CollectModel : BaseModel(), CollectContract.Model {

    override fun getCollectList(page: Int): Observable<HttpResult<CollectionResponseBody<CollectionArticle>>> {
        return RetrofitHelper.service.getCollectList(page)
    }

    override fun removeCollectArticle(id: Int, originId: Int): Observable<HttpResult<Any>> {
        return RetrofitHelper.service.removeCollectArticle(id, originId)
    }

}

package com.example.wankotlin.mvp.model

import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.KnowledgeContract
import com.example.wankotlin.mvp.model.bean.ArticleResponseBody
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable


class KnowledgeModel : CommonModel(), KnowledgeContract.Model {

    override fun requestKnowledgeList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.getKnowledgeList(page, cid)
    }

}
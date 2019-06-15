package com.example.wankotlin.mvp.model

import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.ProjectListContract
import com.example.wankotlin.mvp.model.bean.ArticleResponseBody
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

class ProjectListModel : CommonModel(), ProjectListContract.Model {

    override fun requestProjectList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.getProjectList(page, cid)
    }

}

package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.ProjectContract
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.ProjectTreeBean
import io.reactivex.Observable

class ProjectModel: BaseModel(), ProjectContract.Model {

    override fun requestProjectTree(): Observable<HttpResult<List<ProjectTreeBean>>> {
        return RetrofitHelper.service.getProjectTree()
    }

}
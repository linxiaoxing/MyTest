package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.ProjectListContract
import com.example.wankotlin.mvp.model.ProjectListModel

class ProjectListPresenter : CommonPresenter<ProjectListContract.Model, ProjectListContract.View>(), ProjectListContract.Presenter {

    override fun createModel(): ProjectListContract.Model? = ProjectListModel()

    override fun requestProjectList(page: Int, cid: Int) {
        mModel?.requestProjectList(page, cid)?.ss(mModel, mView, page == 1) {
            mView?.setProjectList(it.data)
        }
    }

}
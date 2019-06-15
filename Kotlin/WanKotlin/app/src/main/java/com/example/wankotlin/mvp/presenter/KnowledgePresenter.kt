package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.KnowledgeContract
import com.example.wankotlin.mvp.model.KnowledgeModel

class KnowledgePresenter : CommonPresenter<KnowledgeContract.Model, KnowledgeContract.View>(), KnowledgeContract.Presenter {

    override fun createModel(): KnowledgeContract.Model? = KnowledgeModel()

    override fun requestKnowledgeList(page: Int, cid: Int) {
        mModel?.requestKnowledgeList(page, cid)?.ss(mModel, mView) {
            mView?.setKnowledgeList(it.data)
        }
    }

}
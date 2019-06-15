package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.base.BasePresenter
import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.KnowledgeTreeContract
import com.example.wankotlin.mvp.model.KnowledgeTreeModel

class KnowledgeTreePresenter : BasePresenter<KnowledgeTreeContract.Model, KnowledgeTreeContract.View>(), KnowledgeTreeContract.Presenter {

    override fun createModel(): KnowledgeTreeContract.Model? = KnowledgeTreeModel()

    override fun requestKnowledgeTree() {
        mModel?.requestKnowledgeTree()?.ss(mModel, mView) {
            mView?.setKnowledgeTree(it.data)
        }
    }

}
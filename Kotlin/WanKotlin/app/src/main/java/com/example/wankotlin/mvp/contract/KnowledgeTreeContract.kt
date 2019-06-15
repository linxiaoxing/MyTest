package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.KnowledgeTreeBody
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/5/8.
 */
interface KnowledgeTreeContract {

    interface View : IView {

        fun scrollToTop()

        fun setKnowledgeTree(lists: List<KnowledgeTreeBody>)

    }

    interface Presenter : IPresenter<View> {

        fun requestKnowledgeTree()

    }

    interface Model : IModel {

        fun requestKnowledgeTree(): Observable<HttpResult<List<KnowledgeTreeBody>>>

    }

}
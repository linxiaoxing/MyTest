package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.CollectionArticle
import com.example.wankotlin.mvp.model.bean.CollectionResponseBody
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

interface CollectContract {

    interface View : IView {

        fun setCollectList(articles: CollectionResponseBody<CollectionArticle>)

        fun showRemoveCollectSuccess(success: Boolean)

        fun scrollToTop()

    }

    interface Presenter : IPresenter<View> {

        fun getCollectList(page: Int)

        fun removeCollectArticle(id: Int, originId: Int)

    }

    interface Model : IModel {

        fun getCollectList(page: Int): Observable<HttpResult<CollectionResponseBody<CollectionArticle>>>

        fun removeCollectArticle(id: Int, originId: Int): Observable<HttpResult<Any>>

    }

}

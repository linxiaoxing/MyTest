package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.ext.ss
import com.example.wankotlin.mvp.contract.SearchListContract
import com.example.wankotlin.mvp.model.SearchListModel

class SearchListPresenter : CommonPresenter<SearchListContract.Model, SearchListContract.View>(), SearchListContract.Presenter {

    override fun createModel(): SearchListContract.Model? = SearchListModel()

    override fun queryBySearchKey(page: Int, key: String) {
        mModel?.queryBySearchKey(page, key)?.ss(mModel, mView, page == 0) {
            mView?.showArticles(it.data)
        }
    }

}
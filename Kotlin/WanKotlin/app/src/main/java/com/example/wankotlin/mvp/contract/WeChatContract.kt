package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.WXChapterBean
import io.reactivex.Observable

interface WeChatContract {

    interface View: IView {

        fun scrollToTop()

        fun showWXChapters(chapters: MutableList<WXChapterBean>)
    }

    interface Presenter: IPresenter<View> {
        fun getWXChapters()
    }

    interface Model: IModel {
        fun getWXChapters(): Observable<HttpResult<MutableList<WXChapterBean>>>
    }
}
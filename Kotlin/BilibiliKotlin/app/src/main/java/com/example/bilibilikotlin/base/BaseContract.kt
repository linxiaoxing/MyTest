package com.example.bilibilikotlin.base

/**
 * 基础契约类 用来管理 presenter 与 view
 */
interface BaseContract {

    interface BaseView {

        /**
         * 请求出错
         */
        fun showError(msg: String)

        /**
         * 请求完成
         */
        fun complete()
    }

    interface BasePresenter<in T> {

        /**
         * 绑定
         * @param view view
         */
        fun  attachView(view: T)

        /**
         * 解绑
         */
        fun detachView()
    }
}
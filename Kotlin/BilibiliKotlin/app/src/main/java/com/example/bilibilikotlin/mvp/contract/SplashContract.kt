package com.example.bilibilikotlin.mvp.contract

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.app.Splash

/**
 * 描述:欢迎界面Contract
 */
interface SplashContract {

    interface View : BaseContract.BaseView {
        fun showSplash(splash: Splash)

        fun showCountDown(count: Int)

    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getSplashData()

        fun setCountDown()

    }

}
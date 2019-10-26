package com.example.bilibilikotlin.mvp.contract.home

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.live.MulLive

interface LiveContract {
    interface View : BaseContract.BaseView {

        fun showMulLive(mulLives: List<MulLive>)

    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getLiveData()

    }
}
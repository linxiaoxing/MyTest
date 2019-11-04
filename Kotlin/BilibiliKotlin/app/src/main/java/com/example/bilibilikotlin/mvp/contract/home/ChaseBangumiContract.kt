package com.example.bilibilikotlin.mvp.contract.home

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.chase.ChaseBangumi
import com.example.bilibilikotlin.bean.chase.RecommendBangumi

interface ChaseBangumiContract {
    interface View : BaseContract.BaseView {
        fun showChaseBangumi(chaseBangumi: ChaseBangumi)

        fun showRecommendBangumi(recommendBangumi: RecommendBangumi)

    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getChaseBangumiData()

    }
}
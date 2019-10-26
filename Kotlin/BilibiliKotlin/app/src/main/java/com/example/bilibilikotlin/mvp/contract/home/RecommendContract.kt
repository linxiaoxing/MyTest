package com.example.bilibilikotlin.mvp.contract.home

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.recommend.Recommend

interface RecommendContract {
    interface View : BaseContract.BaseView {
        fun showRecommend(recommend: List<Recommend>)
    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {
        fun getRecommendData()
    }
}
package com.example.bilibilikotlin.mvp.contract.app.video

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.app.video.MulSummary

/**
 * * 描述:欢迎界面Contract
 */

interface SummaryContract {
    interface View : BaseContract.BaseView {
        fun showSummary(mulSummaries: List<MulSummary>)
    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getSummaryData()


    }
}
package com.example.waneye.mvp.contract

import com.example.waneye.base.BasePresenter
import com.example.waneye.base.BaseView
import com.example.waneye.mvp.model.bean.HotBean

interface HotContract{
    interface View : BaseView<Presenter> {
        fun setData(bean : HotBean)
    }
    interface Presenter : BasePresenter {
        fun requestData(strategy: String)
    }
}
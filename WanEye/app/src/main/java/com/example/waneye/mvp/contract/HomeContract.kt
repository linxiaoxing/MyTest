package com.example.waneye.mvp.contract

import com.example.waneye.base.BasePresenter
import com.example.waneye.base.BaseView
import com.example.waneye.mvp.model.bean.HomeBean

interface HomeContract{
    interface View : BaseView<Presenter> {
        fun setData(bean : HomeBean)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }
}
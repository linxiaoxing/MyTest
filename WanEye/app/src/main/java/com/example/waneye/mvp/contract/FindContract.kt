package com.example.waneye.mvp.contract

import com.example.waneye.base.BasePresenter
import com.example.waneye.base.BaseView
import com.example.waneye.mvp.model.bean.FindBean

interface FindContract{
    interface View : BaseView<Presenter> {
        fun setData(beans : MutableList<FindBean>)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }
}

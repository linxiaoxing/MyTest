package com.example.ordercenter.presenter.view

import com.example.chen.baselibrary.presenter.view.BaseView
import com.kotlin.order.data.protocol.Order

/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}

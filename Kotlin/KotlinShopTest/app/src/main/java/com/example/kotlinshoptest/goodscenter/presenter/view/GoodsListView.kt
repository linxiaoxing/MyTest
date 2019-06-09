package com.example.kotlinshoptest.goodscenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.kotlin.goods.data.protocol.Goods

/*
    商品列表 视图回调
 */
interface GoodsListView : BaseView {

    //获取商品列表
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}

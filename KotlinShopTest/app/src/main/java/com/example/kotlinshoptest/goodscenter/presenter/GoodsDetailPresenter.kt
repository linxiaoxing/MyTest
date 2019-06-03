package com.example.kotlinshoptest.goodscenter.presenter

import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.utils.AppPrefsUtils
import com.example.kotlinshoptest.baselibrary.ext.excute
import com.example.kotlinshoptest.baselibrary.rx.BaseSubscriber
import com.example.kotlinshoptest.goodscenter.common.GoodsConstant
import com.example.kotlinshoptest.goodscenter.presenter.view.GoodsDetailView
import com.example.kotlinshoptest.goodscenter.service.CartService
import com.example.kotlinshoptest.goodscenter.service.GoodsService
import com.kotlin.goods.data.protocol.Goods
import javax.inject.Inject

class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {
    @Inject
    lateinit var goodsService: GoodsService

    @Inject
    lateinit var cartService: CartService
    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).excute(object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                mView.onGetGoodsDetailResult(t)
            }
        }, lifecycleProvider)

    }
    /*
        加入购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,
                goodsCount,goodsSku).excute(object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE,t)
                mView.onAddCartResult(t)
            }
        }, lifecycleProvider)

    }
}
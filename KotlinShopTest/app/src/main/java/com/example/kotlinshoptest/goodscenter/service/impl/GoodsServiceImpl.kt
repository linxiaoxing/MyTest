package com.example.kotlinshoptest.goodscenter.service.impl

import com.example.kotlinshoptest.baselibrary.ext.convert
import com.example.kotlinshoptest.goodscenter.data.repository.GoodsRepository
import com.example.kotlinshoptest.goodscenter.service.GoodsService
import com.kotlin.goods.data.protocol.Goods
import rx.Observable
import javax.inject.Inject

/*
    商品 业务层 实现类
 */
class GoodsServiceImpl @Inject constructor() : GoodsService {
    @Inject
    lateinit var repository: GoodsRepository

    /*
        获取商品列表
     */
    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId, pageNo).convert()
    }

    override fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword,pageNo).convert()
    }
    /*
      获取商品详情
   */
    override fun getGoodsDetail(goodsId: Int): Observable<Goods> {
        return repository.getGoodsDetail(goodsId).convert()
    }
}

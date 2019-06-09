package com.example.kotlinshoptest.goodscenter.injection.module

import com.example.kotlinshoptest.goodscenter.service.GoodsService
import com.example.kotlinshoptest.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品Module
 */
@Module
class GoodsModule {
    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}
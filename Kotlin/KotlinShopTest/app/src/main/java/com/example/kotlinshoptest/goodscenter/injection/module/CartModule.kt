package com.example.kotlinshoptest.goodscenter.injection.module

import com.example.kotlinshoptest.goodscenter.service.CartService
import com.example.kotlinshoptest.goodscenter.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/*
    购物车Module
 */
@Module
class CartModule {

    @Provides
    fun provideCartservice(cartService: CartServiceImpl): CartService {
        return cartService
    }
}
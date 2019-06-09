package com.example.kotlinshoptest.goodscenter.injection.component

import com.example.baselibrary.injection.component.ActivityComponent
import com.example.kotlinshoptest.baselibrary.injection.PerComponentScope
import com.example.kotlinshoptest.goodscenter.injection.module.CartModule
import com.example.kotlinshoptest.goodscenter.injection.module.GoodsModule
import com.example.kotlinshoptest.goodscenter.ui.activity.GoodsActivity
import com.example.kotlinshoptest.goodscenter.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/*
    商品Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(GoodsModule::class),(CartModule::class)])
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)

}
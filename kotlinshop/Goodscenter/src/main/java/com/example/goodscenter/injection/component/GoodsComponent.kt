package com.example.goodscenter.injection.component

import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.goodscenter.injection.module.CartModule
import com.example.goodscenter.injection.module.GoodsModule
import com.example.goodscenter.ui.activity.GoodsActivity
import com.example.goodscenter.ui.fragment.GoodsDetailTabOneFragment
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

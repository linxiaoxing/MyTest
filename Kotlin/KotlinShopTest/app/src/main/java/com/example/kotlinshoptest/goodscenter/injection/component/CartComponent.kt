package com.example.kotlinshoptest.goodscenter.injection.component

import com.example.baselibrary.injection.component.ActivityComponent
import com.example.kotlinshoptest.baselibrary.injection.PerComponentScope
import com.example.kotlinshoptest.goodscenter.injection.module.CartModule
import dagger.Component
import com.example.kotlinshoptest.goodscenter.ui.fragment.CartFragment

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(CartModule::class)])
interface CartComponent {
    fun inject(fragment: CartFragment)
}
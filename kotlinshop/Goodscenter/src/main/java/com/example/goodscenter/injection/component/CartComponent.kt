package com.example.goodscenter.injection.component

import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.goodscenter.injection.module.CartModule
import com.example.goodscenter.ui.fragment.CartFragment
import dagger.Component

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(CartModule::class)])
interface CartComponent {
    fun inject(fragment: CartFragment)
}

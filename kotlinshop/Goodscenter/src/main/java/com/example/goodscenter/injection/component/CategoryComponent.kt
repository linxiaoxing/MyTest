package com.example.goodscenter.injection.component


import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.goodscenter.injection.module.CategoryModule
import com.example.goodscenter.ui.fragment.CategoryFragment
import dagger.Component

/*
    商品分类Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(CategoryModule::class)])
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}

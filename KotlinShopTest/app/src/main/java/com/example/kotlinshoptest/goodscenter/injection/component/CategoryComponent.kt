package com.example.kotlinshoptest.goodscenter.injection.component

import com.example.baselibrary.injection.component.ActivityComponent
import com.example.kotlinshoptest.baselibrary.injection.PerComponentScope
import com.example.kotlinshoptest.goodscenter.injection.module.CategoryModule
import dagger.Component

/*
    商品分类Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(CategoryModule::class)])
interface CategoryComponent {
    //fun inject(fragment: CategoryFragment)
}

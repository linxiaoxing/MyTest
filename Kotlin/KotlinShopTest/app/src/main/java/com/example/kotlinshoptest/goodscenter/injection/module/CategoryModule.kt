package com.example.kotlinshoptest.goodscenter.injection.module

import com.example.kotlinshoptest.goodscenter.service.CategoryService
import com.example.kotlinshoptest.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品分类Module
 */
@Module
class CategoryModule {
    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
package com.example.kotlinshoptest.goodscenter.service.impl

import com.example.kotlinshoptest.baselibrary.ext.convert
import com.example.kotlinshoptest.goodscenter.data.repository.CategoryRepository
import com.example.kotlinshoptest.goodscenter.service.CategoryService
import com.kotlin.goods.data.protocol.Category
import rx.Observable
import javax.inject.Inject


/**
 *  商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor(): CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    /**
     * 获取商品分类列表
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}
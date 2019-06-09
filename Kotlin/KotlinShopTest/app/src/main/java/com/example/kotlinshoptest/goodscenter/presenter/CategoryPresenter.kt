package com.example.kotlinshoptest.goodscenter.presenter

import com.example.baselibrary.presenter.BasePresenter
import com.example.kotlinshoptest.baselibrary.ext.excute
import com.example.kotlinshoptest.baselibrary.rx.BaseSubscriber
import com.example.kotlinshoptest.goodscenter.presenter.view.CategoryView
import com.example.kotlinshoptest.goodscenter.service.CategoryService
import com.kotlin.goods.data.protocol.Category
import javax.inject.Inject

/**
 * 商品分类 Presenter
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService


    /*
        获取商品分类列表
     */
    fun getCategory(parentId:Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId).excute(object : BaseSubscriber<MutableList<Category>?>(mView) {
            override fun onNext(t: MutableList<Category>?) {
                mView.onGetCategoryResult(t)
            }
        }, lifecycleProvider)

    }

}

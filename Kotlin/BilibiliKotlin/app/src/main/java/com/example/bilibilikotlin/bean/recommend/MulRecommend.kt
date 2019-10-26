package com.example.bilibilikotlin.bean.recommend

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * * 描述:推荐多布局
 */

class MulRecommend(val itemTypez: Int = 0,
                   var spanSize: Int = 0,
                   var recommend: Recommend? = null,
                   var data: List<Recommend.BannerItem>? = null) : MultiItemEntity {

    companion object {
        val TYPE_HEADER = 1
        val TYPE_ITEM = 2
        val HEADER_SPAN_SIZE = 2// 占2
        val ITEM_SPAN_SIZE = 1// 占1
    }


    override fun getItemType(): Int = itemTypez


}
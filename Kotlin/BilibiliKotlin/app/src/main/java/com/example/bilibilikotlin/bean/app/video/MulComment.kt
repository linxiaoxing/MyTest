package com.example.bilibilikotlin.bean.app.video

import com.chad.library.adapter.base.entity.MultiItemEntity

class MulComment(var itemTypez: Int = 0,
                 var hotsBean: VideoDetailComment.DataBean.HotsBean? = null,
                 var repliesBean: VideoDetailComment.DataBean.RepliesBean? = null)
    : MultiItemEntity {



    override fun getItemType(): Int = itemTypez


    companion object {


        val TYPE_COMMENT_HOT_ITEM = 2

        val TYPE_COMMENT_MORE = 3

        val TYPE_COMMENT_NOMAL_ITEM = 4
    }
}
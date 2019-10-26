package com.example.bilibilikotlin.adapter.home.live

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.bean.live.support.LiveEnter

class LiveEntranceAdapter(data: List<LiveEnter>?) : BaseQuickAdapter<LiveEnter, BaseViewHolder>(R.layout.item_live_entrance, data) {

    override fun convert(helper: BaseViewHolder, item: LiveEnter) {
        helper.setText(R.id.tv_title, item.title)
            .setImageResource(R.id.iv_icon, item.img)
    }
}
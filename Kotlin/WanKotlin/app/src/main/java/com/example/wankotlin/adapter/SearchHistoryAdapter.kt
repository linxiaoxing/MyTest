package com.example.wankotlin.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wankotlin.R
import com.example.wankotlin.mvp.model.bean.SearchHistoryBean

class SearchHistoryAdapter(private val context: Context?, datas: MutableList<SearchHistoryBean>):
        BaseQuickAdapter<SearchHistoryBean, BaseViewHolder>(R.layout.item_search_history, datas) {

    override fun convert(helper: BaseViewHolder?, item: SearchHistoryBean?) {
        helper ?: return
        item ?: return

        helper.setText(R.id.tv_search_key, item.key)
            .addOnClickListener(R.id.iv_clear)
    }
}
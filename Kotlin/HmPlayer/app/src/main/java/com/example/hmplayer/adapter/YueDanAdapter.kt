package com.example.hmplayer.adapter

import android.content.Context
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.widget.YueDanItemView

class YueDanAdapter : BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {

    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }
}
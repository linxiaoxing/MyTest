package com.example.hmplayer.adapter

import android.content.Context
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.widget.HomeItemView

class HomeAdapter : BaseListAdapter<HomeItemBean, HomeItemView>()  {

    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}
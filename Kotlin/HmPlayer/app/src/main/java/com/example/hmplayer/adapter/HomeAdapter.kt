package com.example.hmplayer.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.view.HomeItemView
import com.example.hmplayer.view.LoadMoreView

class HomeAdapter : BaseListAdapter<HomeItemBean, HomeItemView>()  {
    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}
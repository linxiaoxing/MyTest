package com.example.hmplayer.adapter

import android.content.Context
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.model.VideosBean
import com.example.hmplayer.widget.MvItemView

class MvListAdapter : BaseListAdapter<VideosBean, MvItemView>() {

    override fun refreshItemView(itemView: MvItemView, data: VideosBean) {
        itemView.setData(data)

    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }

}
package com.example.hmplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.view.YueDanItemView

class YueDanAdapter : RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    private var list = ArrayList<YueDanBean.PlayListsBean>()

    fun updateList(list: List<YueDanBean.PlayListsBean>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {

    }

    class YueDanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
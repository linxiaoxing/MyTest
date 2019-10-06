package com.example.hmplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.view.HomeItemView
import com.example.hmplayer.view.LoadMoreView

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    /**
     * 更新処理
     */
    fun updateList(list: List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<HomeItemBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == 1) {
            return HomeHolder(LoadMoreView(parent.context))
        }
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

        if (position == list.size) return

        val data = list.get(position)
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            return 1
        } else {
            return 0
        }
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
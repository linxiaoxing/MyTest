package com.example.hmplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.view.HomeItemView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    /**
     * 更新処理
     */
    fun updateList(list:List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

        val data = list.get(position)
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)
    }



    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
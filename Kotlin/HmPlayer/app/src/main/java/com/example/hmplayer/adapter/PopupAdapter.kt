package com.example.hmplayer.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.hmplayer.model.AudioBean
import com.example.hmplayer.widget.PopupListItemView

class PopupAdapter(var list: List<AudioBean>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: PopupListItemView? = null
        itemView = if (convertView == null) {
            PopupListItemView(parent?.context)
        } else {
            convertView as PopupListItemView
        }
        itemView.setData(list[position])
        return itemView
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}
package com.example.chen.kotlinshop.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chen.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.example.chen.baselibrary.utils.GlideUtils
import com.example.chen.kotlinshop.R
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*

class HomeDiscountAdapter(context:Context):BaseRecyclerViewAdapter<String,HomeDiscountAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(mContext).inflate(R.layout.layout_home_discount_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        GlideUtils.loadImage(mContext,dataList[position],holder.itemView.mGoodsIconIv)
        holder.itemView.mDiscountBeforeTv.text="$1000"
        holder.itemView.mDiscountAfterTv.text="$123"
    }
    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        init {
            //设置TextView样式
            view.mDiscountBeforeTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            view.mDiscountBeforeTv.paint.isAntiAlias = true
        }
    }
}
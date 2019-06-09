package com.example.kotlinshoptest.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.baselibrary.ext.loadUrl
import kotlinx.android.synthetic.main.layout_topic_item.view.*

/*
    话题数据
 */
class TopicAdapter(private val context: Context, private val list: List<String>): PagerAdapter() {

    override fun destroyItem(parent: ViewGroup, position: Int, paramObject: Any) {
        parent.removeView(paramObject as View)
    }

    override fun getCount(): Int {
        return this.list.size
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val rootView = LayoutInflater.from(this.context).inflate(R.layout.layout_topic_item, null)
        rootView.mTopicIv.loadUrl(list[position])
        parent.addView(rootView)
        return rootView
    }

    override fun isViewFromObject(paramView: View, paramObject: Any): Boolean {
        return paramView === paramObject
    }
}
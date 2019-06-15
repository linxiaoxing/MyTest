package com.example.wankotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import com.example.wankotlin.mvp.model.bean.TodoTypeBean
import com.example.wankotlin.ui.fragment.TodoFragment

class TodoPagerAdapter(val list: List<TodoTypeBean>, fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private val fragments = mutableListOf<TodoFragment>()

    init {
        fragments.clear()
        list.forEach {
            fragments.add(TodoFragment.getInstance(it.type))
        }
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? = list[position].name

    override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE
}
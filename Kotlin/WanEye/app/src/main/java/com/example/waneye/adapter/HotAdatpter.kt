package com.example.waneye.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class HotAdatpter(fm: FragmentManager, list: ArrayList<Fragment>, titles : MutableList<String>) : FragmentPagerAdapter(fm) {
    val mFm : FragmentManager = fm!!
    val mList : ArrayList<Fragment> = list
    val mTitles : MutableList<String> = titles

    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }
}
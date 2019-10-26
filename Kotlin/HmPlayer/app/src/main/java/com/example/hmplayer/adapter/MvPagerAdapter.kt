package com.example.hmplayer.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hmplayer.model.MvAreaBean
import com.example.hmplayer.ui.fragment.MvPagerFragment

class MvPagerAdapter(val list: List<MvAreaBean>?, fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        // 第一种Fragment数据传递方式：argument
        val fragment = MvPagerFragment()
        val bundle = Bundle()
        bundle.putString("args", list?.get(position)?.name)
        fragment.arguments = bundle

        // 第二种Fragment数据传递方式：instance
//         val fragment = MvPagerFragment()
        return fragment
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list?.get(position)?.name
    }

}
package com.example.bilibilikotlin.adapter.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.module.home.LiveFragment
import com.example.bilibilikotlin.module.home.RecommendFragment
import com.example.bilibilikotlin.utils.AppUtils

@Suppress("DEPRECATION")
class MainAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if (mFragment[position] == null) {
            when (position) {
                0 ->
                    //直播
                    mFragment[position] = LiveFragment.newInstance()
                1 ->
                    //推荐
                    mFragment[position] = RecommendFragment.newInstance()
                2 ->
                    //追番
                    mFragment[position] = LiveFragment.newInstance()
                3 ->
                    //分区
                    mFragment[position] = LiveFragment.newInstance()
                4 ->
                    //动态
                    mFragment[position] = LiveFragment.newInstance()
                5 ->
                    //发现
                    mFragment[position] = LiveFragment.newInstance()
            }
        }
        return mFragment[position]!!
    }

    private val mTitle = AppUtils.getStringArray(R.array.main_title)
    private val mFragment = arrayOfNulls<Fragment>(mTitle.size)



    override fun getCount(): Int = mTitle.size


    override fun getPageTitle(position: Int): CharSequence = mTitle[position]

}
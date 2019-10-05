package com.example.hmplayer.util

import com.example.hmplayer.R
import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.ui.fragment.HomeFragment
import com.example.hmplayer.ui.fragment.MvFragment
import com.example.hmplayer.ui.fragment.VBangFragment
import com.example.hmplayer.ui.fragment.YueDanFragment

class FragmentUtil private constructor(){


    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabId获取对应的fragment
     */
    fun getFragment(tabId: Int): BaseFragment? {
        when(tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vbang -> return vbangFragment
            R.id.tab_yuedan -> return yuedanFragment
        }
        return null
    }
}
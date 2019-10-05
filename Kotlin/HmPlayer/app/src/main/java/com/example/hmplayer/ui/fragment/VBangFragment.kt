package com.example.hmplayer.ui.fragment

import android.view.View
import android.widget.TextView
import com.example.hmplayer.base.BaseFragment

class VBangFragment: BaseFragment() {

    override fun initView(): View? {
        val tv = TextView(context)
        tv.text = javaClass.simpleName
        return tv
    }
}
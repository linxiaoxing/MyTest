package com.example.wankotlin.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.wankotlin.R
import com.example.wankotlin.base.BaseFragment

class SettingFragment : BaseFragment() {


    companion object {
        fun getInstance(bundle: Bundle): SettingFragment {
            val fragment = SettingFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_setting

    override fun initView(view: View) {
    }

    override fun lazyLoad() {
    }
}
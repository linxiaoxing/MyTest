package com.example.bilibilikotlin.module.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.base.BaseFragment

abstract class BaseHomeFragment : BaseFragment() {
    var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)//支持menu
    }

    override fun initWidget() {
        initToolbar()
    }

    @SuppressLint("CheckResult")
    private fun initToolbar() {
        mToolbar = mRootView?.findViewById(R.id.toolbar) as Toolbar
        mToolbar?.let {
            it.title = ""
            (activity as AppCompatActivity).setSupportActionBar(mToolbar)
            //换成下面这句就OK了
            it.inflateMenu(R.menu.menu_main)
        }

    }
}
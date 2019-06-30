package com.example.wanandroidmvvm.ui

import com.example.base.BaseNormalActivity
import com.example.wanandroidmvvm.R
import com.example.wanandroidmvvm.ui.main.NewMainActivity

class SplashNormalActivity: BaseNormalActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun initView() {
        startActivity(NewMainActivity::class.java)
    }

    override fun initData() {
    }
}
package com.example.chen.kotlinshop.common

import cn.jpush.android.api.JPushInterface
import com.example.chen.baselibrary.common.BaseApplication

/*
    主工程 Application
 */
class MainApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}



package com.example.gsykotlin.module.main

import com.example.gsykotlin.R
import org.jetbrains.anko.toast

/**
 * 主页退出逻辑
 * Created by guoshuyu
 * Date: 2018-11-09
 */
class MainExitLogic(private val activity: MainActivity) {

    var firstTime = 0L


    fun backPress() {
        val secondTime = System.currentTimeMillis()
        if (secondTime - firstTime > 2000) {
            activity.toast(R.string.doublePressExit)
            firstTime = secondTime
            return
        } else {
            System.exit(0)
        }
    }

}
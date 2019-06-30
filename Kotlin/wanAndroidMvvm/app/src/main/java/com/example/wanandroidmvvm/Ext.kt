package com.example.wanandroidmvvm

import android.view.View

const val TOOL_URL = "http://www.wanandroid.com/tools"
const val GITHUB_PAGE= "https://github.com/lulululbj/wanandroid"
const val HOME_PAGE = "http://sunluyao.com"
const val ISSUE_URL="https://github.com/lulululbj/wanandroid/issues"

fun View.dp2px(dp: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}
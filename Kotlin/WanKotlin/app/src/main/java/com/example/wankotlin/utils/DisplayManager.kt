package com.example.wankotlin.utils

import android.content.Context
import android.util.DisplayMetrics

object DisplayManager {
    init {

    }
    private var displayMetrics: DisplayMetrics? = null

    fun init(context: Context) {
        displayMetrics = context.resources.displayMetrics
    }

    /**
     * dip转px
     * @param dipValue
     * @return int
     */
    fun dip2px(disValue: Float): Int {
        val scale = displayMetrics?.density
        return (disValue * scale!! +  0.5f).toInt()

    }


}
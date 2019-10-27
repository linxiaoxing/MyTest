package com.example.gsygithubappkotlin.common.utils

import android.graphics.Point
import android.widget.ImageView
import com.example.gsygithubappkotlin.R
import com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoaderManager
import com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption

/**
 * 通用工具类
 */
object CommonUtils {

    private const val MILLIS_LIMIT = 1000.0

    private const val SECONDS_LIMIT = 60 * MILLIS_LIMIT

    private const val MINUTES_LIMIT = 60 * SECONDS_LIMIT

    private const val HOURS_LIMIT = 24 * MINUTES_LIMIT

    private const val DAYS_LIMIT = 30 * HOURS_LIMIT

    /**
     * 加载用户头像
     */
    fun loadUserHeaderImage(imageView: ImageView, url: String, size: Point = Point(50.dp, 50.dp)) {
        val option = GSYLoadOption()
            .setDefaultImg(R.drawable.logo)
            .setErrorImg(R.drawable.logo)
            .setCircle(true)
            .setSize(size)
            .setUri(url)
        GSYImageLoaderManager.sInstance.imageLoader().loadImage(option, imageView, null)
    }
}

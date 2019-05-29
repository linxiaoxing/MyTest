package com.example.kotlinshoptest.baselibrary.ext

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.baselibrary.utils.GlideUtils

/**
 * ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

fun View.OnClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}
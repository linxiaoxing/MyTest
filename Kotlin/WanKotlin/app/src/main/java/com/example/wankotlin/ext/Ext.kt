package com.example.wankotlin.ext

import android.content.Context
import com.example.wankotlin.widget.CustomToast

fun Context.showToast(content: String) {
    CustomToast(this, content).show()
}


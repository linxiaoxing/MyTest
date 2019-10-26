package com.example.bilibilikotlin.ext

import android.widget.Toast
import com.example.bilibilikotlin.App

/**
 * 描述:弹吐司
 */
fun String.toast(): Unit {
    Toast.makeText(App.instance, this, Toast.LENGTH_LONG).show()
}
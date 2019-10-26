package com.example.bilibilikotlin.ext

import android.content.Context
import com.example.bilibilikotlin.App

fun Context.getComponent() = App.instance.appComponent

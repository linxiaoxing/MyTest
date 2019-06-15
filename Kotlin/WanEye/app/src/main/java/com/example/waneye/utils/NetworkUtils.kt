package com.example.waneye.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {

    fun isNetConnected(context: Context): Boolean {
        val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager

        val networkInfo : NetworkInfo? = connectManager.activeNetworkInfo

        networkInfo.let {
            return it!!.isAvailable&& it!!.isConnected
        }
        return  false
    }
}
package com.example.wankotlin.utils

import android.content.Context
import android.net.ConnectivityManager

class NetWorkUtil {

    companion object {
        val NET_CNNT_BAIDU_OK = 1 // NetworkAvailable
        val NET_CNNT_BAIDU_TIMEOUT = 2 // no NetworkAvailable
        val NET_NOT_PREPARE = 3 // Net no ready
        val NET_ERROR = 4 //net error
        private val TIMEOUT = 3000 // TIMEOUT

        /**
         * check NetworkAvailable
         *
         * @param context
         * @return
         */
        @JvmStatic
        fun isNetworkAvailable(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(null == info || !info.isAvailable)
        }

        /**
         * check NetworkConnected
         *
         * @param context
         * @return
         */
        fun isNetworkConnected(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(null == info || !info.isConnected)
        }

        /**
         * isWifi
         *
         * @param context
         * @return boolean
         */
        @JvmStatic
        fun isWifi(context: Context): Boolean {
            val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetInfo =  connectivityManager.activeNetworkInfo
            return activeNetInfo != null && activeNetInfo.type == ConnectivityManager.TYPE_WIFI
        }
    }

}
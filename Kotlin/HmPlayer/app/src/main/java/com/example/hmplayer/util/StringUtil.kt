package com.example.hmplayer.util

object StringUtil {

    val HOUR = 60 * 60 * 1000
    val MIN = 60 * 1000
    val SEC = 1000

    fun parseDuration(progress: Int): String {

        val hour = progress / HOUR
        val min = progress % HOUR / MIN
        val sec = progress % MIN / SEC

        return if (hour == 0) {
            String.format("%02d:%02d", min, sec)
        } else {
            String.format("%02d:%02d:%02d", hour, min, sec)
        }
    }
}
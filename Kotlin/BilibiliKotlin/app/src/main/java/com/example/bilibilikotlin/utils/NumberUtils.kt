package com.example.bilibilikotlin.utils

object NumberUtils {
    fun format(num: String): String {
        val integer = Integer.valueOf(num)
        if (integer < 10000) {
            return num
        }
        val unit = "万"
        val newNum = integer / 10000.0
        val numStr = String.format("%." + 1 + "f", newNum)
        return numStr + unit
    }
}
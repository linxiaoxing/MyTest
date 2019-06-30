package com.example.base

data class WanResponse<out T>(val errorCode: Int, val  errorMsg: String, val data: T)
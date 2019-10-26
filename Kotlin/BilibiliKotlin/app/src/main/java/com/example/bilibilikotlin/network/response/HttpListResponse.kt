package com.example.bilibilikotlin.network.response

class HttpListResponse<T> {
    var data: List<T>? = null//数据
    var result: List<T>? = null//数据
    var message: String? = null//信息
    var code: Int = 0//服务器状态
}
package com.example.hmplayer.base

/**
 * @Description 所有view接口的基类
 */
interface BaseView<T> {
    fun onError(message: String?)
    fun onLoadDataSuccess(response: T?)
    fun onLoadMoreSuccess(response: T?)
}
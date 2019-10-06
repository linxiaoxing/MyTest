package com.example.hmplayer.net

interface ResponseHandler<T> {

    fun onError(msg: String?)
    fun onSuccess(type:Int, result: T)
}
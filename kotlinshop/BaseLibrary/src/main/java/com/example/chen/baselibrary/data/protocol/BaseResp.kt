package com.example.chen.baselibrary.data.protocol

class BaseResp<T>(val status:Int,val message:String,val data:T) {
}
package com.example.kotlinshoptest.messagecenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import com.example.kotlinshoptest.messagecenter.data.protocol.Message
import retrofit2.http.POST
import rx.Observable

/*
    消息 接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>
}
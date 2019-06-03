package com.example.kotlinshoptest.messagecenter.service

import com.example.kotlinshoptest.messagecenter.data.protocol.Message
import rx.Observable

/*
   消息业务接口
 */
/*
   消息业务接口
 */
interface MessageService {
    //　获取消息列表
    fun getMessageList(): Observable<MutableList<Message>?>

    // DBから获取消息列表
    fun getMessageListFromDb(): List<Message>?

}
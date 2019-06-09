package com.example.kotlinshoptest.messagecenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.kotlinshoptest.messagecenter.data.api.MessageApi
import com.example.kotlinshoptest.messagecenter.data.protocol.Message
import io.realm.Realm
import rx.Observable
import javax.inject.Inject

/*
   消息数据层
 */
class MessageRepository @Inject constructor() {


    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {

         return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }

    /*
        DBから获取消息列表
     */
    fun getMessageListFromDb(): List<Message>? {

        val realm = Realm.getDefaultInstance()
        //全件取得
        val all = realm.where(Message::class.java).findAll().toList()
        return all
        // return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }

}
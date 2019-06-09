package com.example.kotlinshoptest.messagecenter.data.protocol

import io.realm.RealmObject

/*
    消息实体
 */
open class Message(
        var msgIcon: String? = "",
        var msgTitle:String? = "",
        var msgContent:String? = "",
        var msgTime:String? = "")
        : RealmObject()
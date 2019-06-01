package com.example.kotlinshoptest.messagecenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.kotlinshoptest.messagecenter.data.protocol.Message

/*
    消息列表 视图回调
 */
interface MessageView: BaseView {

    //获取消息列表回调
    fun onGetMessageResult(result:MutableList<Message>?)
}
package com.example.kotlinshoptest.messagecenter.presenter

import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import com.example.kotlinshoptest.baselibrary.ext.excute
import com.example.kotlinshoptest.baselibrary.rx.BaseSubscriber
import com.example.kotlinshoptest.messagecenter.data.protocol.Message
import com.example.kotlinshoptest.messagecenter.presenter.view.MessageView
import com.example.kotlinshoptest.messagecenter.service.MessageService
import javax.inject.Inject

/*
    消息列表 Presenter
 */
class MessagePresenter @Inject constructor(): BasePresenter<MessageView>() {

    @Inject
    lateinit var messageService: MessageService

    /*
       获取消息列表
    */
    fun getMessageList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
//        messageService.getMessageList().excute(object : BaseSubscriber<MutableList<Message>?>(mView) {
//            override fun onNext(t: MutableList<Message>?) {
//                mView.onGetMessageResult(t)
//            }
//        }, lifecycleProvider)
        val messages = messageService.getMessageListFromDb()
        if (messages!!.isNotEmpty()) {
            mView.onGetMessageResult(messages!!.toMutableList())
        }

    }
}
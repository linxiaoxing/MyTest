package com.example.kotlinshoptest.messagecenter.injection.module

import com.example.kotlinshoptest.messagecenter.service.MessageService
import com.example.kotlinshoptest.messagecenter.service.impl.MessageServiceImpl
import dagger.Module
import dagger.Provides

/*
    消息模块业务注入
 */
@Module
class MessageModule {

    @Provides
    fun provideMessageService(messageService: MessageServiceImpl): MessageService {
        return  messageService
    }
}
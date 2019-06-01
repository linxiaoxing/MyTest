package com.example.kotlinshoptest.messagecenter.injection.component

import com.example.baselibrary.injection.component.ActivityComponent
import com.example.kotlinshoptest.baselibrary.injection.PerComponentScope
import com.example.kotlinshoptest.messagecenter.injection.module.MessageModule
import com.example.kotlinshoptest.messagecenter.ui.fragment.MessageFragment
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
        modules = [(MessageModule::class)])
interface MessageComponent{
    fun inject(fragment: MessageFragment)
}

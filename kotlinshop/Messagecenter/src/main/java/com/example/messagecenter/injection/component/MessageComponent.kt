package com.kotlin.message.injection.component


import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.kotlin.message.injection.module.MessageModule
import com.kotlin.message.ui.fragment.MessageFragment
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
        modules = [(MessageModule::class)])
interface MessageComponent{
    fun inject(fragment:MessageFragment)
}

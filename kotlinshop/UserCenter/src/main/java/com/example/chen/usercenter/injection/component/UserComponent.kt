package com.example.chen.usercenter.injection.component

import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.chen.usercenter.injection.module.UploadModule
import com.example.chen.usercenter.injection.module.UserModule
import com.example.chen.usercenter.ui.activity.*
import dagger.Component
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(UserModule::class),UploadModule::class])
interface UserComponent {
    fun inject(activity:RegisterActivity)
    fun inject(activity:LoginActivity)
    fun inject(activity:ForgetPwdActivity)
    fun inject(activity:ResetPwdActivity)
    fun inject(activity:UserInfoActivity)
}
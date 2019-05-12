package com.example.chen.usercenter.injection.module

import com.example.chen.usercenter.service.UserService
import com.example.chen.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun providerUserService(service: UserServiceImpl): UserService {
        return service;
    }

}
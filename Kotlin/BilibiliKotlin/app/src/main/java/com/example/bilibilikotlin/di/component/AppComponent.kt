package com.example.bilibilikotlin.di.component

import android.content.Context
import com.example.bilibilikotlin.di.module.ApiModule
import com.example.bilibilikotlin.di.module.AppModule
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import dagger.Component
import javax.inject.Singleton

/**
 *  描述:AppComponent
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {

    fun getContext(): Context

    fun getRetrofitHelper(): RetrofitHelper

}
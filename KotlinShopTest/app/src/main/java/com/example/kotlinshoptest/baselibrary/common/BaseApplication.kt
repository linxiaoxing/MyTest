package com.example.baselibrary.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.injection.component.AppComponent
import com.example.baselibrary.injection.component.DaggerAppComponent
import com.example.baselibrary.injection.module.AppModule

open class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
        context = this

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);

    }

    companion object {
        lateinit var context: Context
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
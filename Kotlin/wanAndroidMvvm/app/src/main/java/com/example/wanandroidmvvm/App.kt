package com.example.wanandroidmvvm

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.wanandroidmvvm.model.bean.User
import com.squareup.leakcanary.LeakCanary
import kotlin.properties.Delegates

class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext

//        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
//        val cb = object : QbSdk.PreInitCallback {
//
//            override fun onViewInitFinished(arg0: Boolean) {
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                Log.d("app", " onViewInitFinished is $arg0")
//            }
//
//            override fun onCoreInitFinished() {
//            }
//        }
//        //x5内核初始化接口
//        QbSdk.initX5Environment(applicationContext, cb)

        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)
    }
}
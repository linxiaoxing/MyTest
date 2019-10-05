package com.example.gsykotlin

import android.app.Activity
import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.gsykotlin.common.db.RealmFactory
import com.example.gsykotlin.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import javax.inject.Inject
import kotlin.properties.Delegates

class GSYGithubApplication : Application(), HasActivityInjector {

    companion object {
        var instance: GSYGithubApplication by Delegates.notNull()
    }

    /**
     * 分发Activity的注入
     *
     * 在Activity调用AndroidInjection.inject(this)时
     * 从Application获取一个DispatchingAndroidInjector<Activity>，并将activity传递给inject(activity)
     * DispatchingAndroidInjector通过AndroidInjector.Factory创建AndroidInjector
     */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        instance = this

        ///初始化路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

//        //Application级别注入
//        AppInjector.init(this)


        ///数据库
        Realm.init(this)
        RealmFactory.instance
    }

    override fun activityInjector() = dispatchingAndroidInjector
}
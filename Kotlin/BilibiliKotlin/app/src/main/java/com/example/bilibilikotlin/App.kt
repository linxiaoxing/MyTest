package com.example.bilibilikotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.bilibilikotlin.di.component.AppComponent
import com.example.bilibilikotlin.di.component.DaggerAppComponent
import com.example.bilibilikotlin.di.module.ApiModule
import com.example.bilibilikotlin.di.module.AppModule
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.utils.CrashHandler
import com.example.bilibilikotlin.utils.LogUtils
import com.example.bilibilikotlin.utils.PrefsUtils
import com.example.bilibilikotlin.utils.net.NetworkUtils
import com.facebook.stetho.Stetho

class App : Application() {

    private var allActivities: HashSet<Activity>? = null
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .apiModule(ApiModule())
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
    }


    override fun onCreate() {
        super.onCreate()
        AppUtils.init(this)
        instance = this
        initNetwork()
        initStetho()
        initCrashHandler()
        initLog()
        initPrefs()
    }

    /**
     * 开启网络监听
     */
    private fun initNetwork() {
        NetworkUtils.startNetService(this)

    }

    /**
     * 初始化log
     */
    private fun initLog() {
        LogUtils.init(this)
    }

    /**
     * 初始化调试
     */
    private fun initStetho() {
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build())
    }

    /**
     * 初始化崩溃日志
     */
    private fun initCrashHandler() {
        CrashHandler.getInstance().init(this)
    }

    /**
     * 初始化sp
     */
    private fun initPrefs() {
        PrefsUtils.init(this, packageName + "_preference", Context.MODE_MULTI_PROCESS)
    }

    /**
     * 增加Activity
     * @param act act
     */
    fun addActivity(act: Activity) {
        if (allActivities == null) {
            allActivities = HashSet<Activity>()
        } else {
            allActivities?.add(act)
        }
    }

    /**
     * 移除Activity
     * @param act act
     */
    fun removeActivity(act: Activity) {
        if (allActivities?.contains(act) ?: false) {
            allActivities?.remove(act)
        }
    }

    /**
     * 退出应用
     */
    @Synchronized fun exitApp() {
        allActivities?.let {
            for (act in it) {
                act.finish()
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }
}
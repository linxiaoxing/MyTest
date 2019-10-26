package com.example.musicplayersam

import android.app.Application
import com.example.musicplayersam.utils.component.AppTask

class AppContext : Application() {

    /**
     * singleton for application
     */
    companion object: Application()

    override fun onCreate() {
        super.onCreate()
        AppContext.attachBaseContext(this)
        AppContext.setTheme(R.style.AppTheme)
        registerActivityLifecycleCallbacks(AppTask.CallBack)
    }

}
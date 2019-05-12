package com.example.chen.baselibrary.injection.module

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
@Module
    class ActivityModule(private val activity: Activity) {
    @Provides
    fun providesActivity(): Activity {
        return this.activity
    }
}
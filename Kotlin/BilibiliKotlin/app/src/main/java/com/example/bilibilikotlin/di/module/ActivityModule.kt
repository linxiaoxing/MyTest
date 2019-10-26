package com.example.bilibilikotlin.di.module

import android.app.Activity
import com.example.bilibilikotlin.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * * 描述:Activity模型
 */
@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = activity
}
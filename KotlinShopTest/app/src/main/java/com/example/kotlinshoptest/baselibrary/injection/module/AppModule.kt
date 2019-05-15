package com.example.baselibrary.injection.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return this.context
    }
}
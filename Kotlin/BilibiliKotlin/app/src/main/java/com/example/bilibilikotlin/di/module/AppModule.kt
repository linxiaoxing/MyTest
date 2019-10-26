package com.example.bilibilikotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * * 描述:App模型
 */
@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context

}
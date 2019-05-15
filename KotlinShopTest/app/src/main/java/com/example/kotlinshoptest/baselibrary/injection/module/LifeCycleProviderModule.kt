package com.example.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

@Module
class LifeCycleProviderModule(private val lifecycleprovider: LifecycleProvider<*>) {
    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return this.lifecycleprovider
    }
}
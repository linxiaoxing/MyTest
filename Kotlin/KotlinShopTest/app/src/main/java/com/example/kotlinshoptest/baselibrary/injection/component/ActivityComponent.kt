package com.example.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.example.baselibrary.injection.ActivityScope
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class), (LifeCycleProviderModule::class)])
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
package com.example.chen.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.chen.baselibrary.injection.ActivityScope
import com.example.chen.baselibrary.injection.module.ActivityModule
import com.example.chen.baselibrary.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component
@ActivityScope
@Component(dependencies = [(AppComponent::class)],modules = [(ActivityModule::class),(LifeCycleProviderModule::class)])
interface ActivityComponent {
    fun activity():Activity
    fun context():Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
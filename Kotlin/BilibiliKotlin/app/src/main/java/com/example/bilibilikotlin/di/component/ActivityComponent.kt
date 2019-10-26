package com.example.bilibilikotlin.di.component

import android.app.Activity
import com.example.bilibilikotlin.di.module.ActivityModule
import com.example.bilibilikotlin.di.scope.ActivityScope
import com.example.bilibilikotlin.module.app.SplashActivity
import com.example.bilibilikotlin.module.app.video.VideoDetailActivity
import com.example.bilibilikotlin.module.app.video.VideoPlayerActivity
import dagger.Component

/**
 * * 描述:ActivityComponent
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun getActivity(): Activity

    fun inject(splashActivity: SplashActivity)

    fun inject(videoDetailActivity: VideoDetailActivity)

    fun inject(videoPlayerActivity: VideoPlayerActivity)
}
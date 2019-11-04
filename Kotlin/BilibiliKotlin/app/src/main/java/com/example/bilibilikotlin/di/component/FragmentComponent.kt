package com.example.bilibilikotlin.di.component

import android.app.Activity
import com.example.bilibilikotlin.di.module.FragmentModule
import com.example.bilibilikotlin.di.scope.FragmentScope
import com.example.bilibilikotlin.module.app.video.CommentFragment
import com.example.bilibilikotlin.module.app.video.SummaryFragment
import com.example.bilibilikotlin.module.home.ChaseBangumiFragment
import com.example.bilibilikotlin.module.home.LiveFragment
import com.example.bilibilikotlin.module.home.RecommendFragment
import dagger.Component

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun getActivity(): Activity

    fun inject(liveFragment: LiveFragment)

    fun inject(recommendFragment: RecommendFragment)

    fun inject(summaryFragment: SummaryFragment)

    fun inject(commentFragment: CommentFragment)

    fun inject(chaseBangumiFragment: ChaseBangumiFragment)
}
package com.example.bilibilikotlin.di.module

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.bilibilikotlin.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideActivity(): Activity = fragment.activity as Activity

}
package com.example.bilibilikotlin.di.component;

import java.lang.System;

/**
 * * 描述:ActivityComponent
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/example/bilibilikotlin/di/component/ActivityComponent;", "", "getActivity", "Landroid/app/Activity;", "inject", "", "splashActivity", "Lcom/example/bilibilikotlin/module/app/SplashActivity;", "videoDetailActivity", "Lcom/example/bilibilikotlin/module/app/video/VideoDetailActivity;", "videoPlayerActivity", "Lcom/example/bilibilikotlin/module/app/video/VideoPlayerActivity;", "app_debug"})
@dagger.Component(dependencies = {com.example.bilibilikotlin.di.component.AppComponent.class}, modules = {com.example.bilibilikotlin.di.module.ActivityModule.class})
@com.example.bilibilikotlin.di.scope.ActivityScope()
public abstract interface ActivityComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.app.Activity getActivity();
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.app.SplashActivity splashActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.app.video.VideoDetailActivity videoDetailActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.app.video.VideoPlayerActivity videoPlayerActivity);
}
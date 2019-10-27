package com.example.bilibilikotlin.di.component;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/bilibilikotlin/di/component/FragmentComponent;", "", "getActivity", "Landroid/app/Activity;", "inject", "", "commentFragment", "Lcom/example/bilibilikotlin/module/app/video/CommentFragment;", "summaryFragment", "Lcom/example/bilibilikotlin/module/app/video/SummaryFragment;", "liveFragment", "Lcom/example/bilibilikotlin/module/home/LiveFragment;", "recommendFragment", "Lcom/example/bilibilikotlin/module/home/RecommendFragment;", "app_debug"})
@dagger.Component(dependencies = {com.example.bilibilikotlin.di.component.AppComponent.class}, modules = {com.example.bilibilikotlin.di.module.FragmentModule.class})
@com.example.bilibilikotlin.di.scope.FragmentScope()
public abstract interface FragmentComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.app.Activity getActivity();
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.home.LiveFragment liveFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.home.RecommendFragment recommendFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.app.video.SummaryFragment summaryFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.module.app.video.CommentFragment commentFragment);
}
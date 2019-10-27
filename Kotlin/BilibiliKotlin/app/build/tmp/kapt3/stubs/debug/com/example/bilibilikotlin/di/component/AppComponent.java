package com.example.bilibilikotlin.di.component;

import java.lang.System;

/**
 * 描述:AppComponent
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/bilibilikotlin/di/component/AppComponent;", "", "getContext", "Landroid/content/Context;", "getRetrofitHelper", "Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;", "app_debug"})
@dagger.Component(modules = {com.example.bilibilikotlin.di.module.AppModule.class, com.example.bilibilikotlin.di.module.ApiModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context getContext();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.bilibilikotlin.network.helper.RetrofitHelper getRetrofitHelper();
}
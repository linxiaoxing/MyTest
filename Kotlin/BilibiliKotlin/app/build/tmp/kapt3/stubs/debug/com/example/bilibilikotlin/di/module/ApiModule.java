package com.example.bilibilikotlin.di.module;

import java.lang.System;

/**
 * * 描述:Api网络模型
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0019\u001a\u00020\u0006H\u0007J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0016H\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/example/bilibilikotlin/di/module/ApiModule;", "", "()V", "createRetrofit", "Lretrofit2/Retrofit;", "builder", "Lretrofit2/Retrofit$Builder;", "client", "Lokhttp3/OkHttpClient;", "url", "", "provideApiRetrofit", "provideApiService", "Lcom/example/bilibilikotlin/network/api/ApiService;", "retrofit", "provideAppRetrofit", "provideAppService", "Lcom/example/bilibilikotlin/network/api/AppService;", "provideBangumiRetrofit", "provideIm9Retrofit", "provideLiveRetrofit", "provideLiveService", "Lcom/example/bilibilikotlin/network/api/LiveService;", "provideOkHttpClient", "provideRankRetrofit", "provideRetrofitBuilder", "provideRetrofitHelper", "Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;", "appService", "apiService", "liveService", "app_debug"})
@dagger.Module()
public final class ApiModule {
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit createRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit.Builder provideRetrofitBuilder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.bilibilikotlin.network.helper.RetrofitHelper provideRetrofitHelper(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.AppService appService, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.LiveService liveService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.AppUrl()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideAppRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.bilibilikotlin.network.api.AppService provideAppService(@org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.AppUrl()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.LiveUrl()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideLiveRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.bilibilikotlin.network.api.LiveService provideLiveService(@org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.LiveUrl()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.BangumiUrl()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideBangumiRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.RankUrl()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideRankRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.bilibilikotlin.network.api.ApiService provideApiService(@org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.ApiUrl()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.ApiUrl()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideApiRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.example.bilibilikotlin.di.qualifier.Im9Url()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideIm9Retrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder builder, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    public ApiModule() {
        super();
    }
}
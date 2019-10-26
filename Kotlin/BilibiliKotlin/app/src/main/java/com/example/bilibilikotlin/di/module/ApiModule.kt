package com.example.bilibilikotlin.di.module

import com.example.bilibilikotlin.di.qualifier.*
import com.example.bilibilikotlin.network.api.ApiService
import com.example.bilibilikotlin.network.api.AppService
import com.example.bilibilikotlin.network.api.LiveService
import com.example.bilibilikotlin.network.helper.OkHttpHelper
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.network.support.ApiConstants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * * 描述:Api网络模型
 */
@Module
class ApiModule {

    fun createRetrofit(builder: Retrofit.Builder, client: OkHttpClient, url: String): Retrofit
            = builder
        .baseUrl(url)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpHelper.getOkHttpClient()

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideRetrofitHelper(appService: AppService, apiService: ApiService, liveService: LiveService): RetrofitHelper
            = RetrofitHelper(appService, apiService, liveService)

    @Singleton
    @Provides
    @AppUrl
    fun provideAppRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit =
        createRetrofit(builder, client, ApiConstants.APP_BASE_URL)

    @Singleton
    @Provides
    fun provideAppService(@AppUrl retrofit: Retrofit): AppService
            = retrofit.create(AppService::class.java)


    @Singleton
    @Provides
    @LiveUrl
    fun provideLiveRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit
            = createRetrofit(builder, client, ApiConstants.LIVE_BASE_URL)

    @Singleton
    @Provides
    fun provideLiveService(@LiveUrl retrofit: Retrofit): LiveService
            = retrofit.create<LiveService>(LiveService::class.java)

    @Singleton
    @Provides
    @BangumiUrl
    fun provideBangumiRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit
            = createRetrofit(builder, client, ApiConstants.BANGUMI_BASE_URL)

    @Singleton
    @Provides
    @RankUrl
    fun provideRankRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit
            = createRetrofit(builder, client, ApiConstants.RANK_BASE_URL)


    @Singleton
    @Provides
    fun provideApiService(@ApiUrl retrofit: Retrofit): ApiService
            = retrofit.create<ApiService>(ApiService::class.java)

    @Singleton
    @Provides
    @ApiUrl
    fun provideApiRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit
            = createRetrofit(builder, client, ApiConstants.API_BASE_URL)


    @Singleton
    @Provides
    @Im9Url
    fun provideIm9Retrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit
            = createRetrofit(builder, client, ApiConstants.IM9_BASE_URL)

}
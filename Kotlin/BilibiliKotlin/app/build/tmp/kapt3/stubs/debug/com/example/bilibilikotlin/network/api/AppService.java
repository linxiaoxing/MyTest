package com.example.bilibilikotlin.network.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/network/api/AppService;", "", "getSplash", "Lio/reactivex/Flowable;", "Lcom/example/bilibilikotlin/bean/app/Splash;", "getVideoDetail", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetail;", "getVideoPlayer", "Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer;", "app_debug"})
public abstract interface AppService {
    
    /**
     * splash界面
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/x/v2/splash?mobi_app=android&build=505000&channel=360&width=1080&height=1920&ver=4344558841496142006")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.Splash> getSplash();
    
    /**
     * 视频详情
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/x/v2/view?access_key=18b6350cf0e8fb0cacb6cf323fc2feba&aid=3852397&appkey=1d8b6e7d45233436&build=505000&from=3&mobi_app=android&plat=0&platform=android&trackid=14859045423998458858&ts=1498645383&sign=94a3c4d143f44f023558ea52a33be403")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoDetail> getVideoDetail();
    
    /**
     * 获取视频播放
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/playurl?device=android&qn=16&cid=6191437&appkey=iVGUTjsxvpLeuDCf&access_key=18b6350cf0e8fb0cacb6cf323fc2feba&otype=json&mid=117143614&build=505000&buvid=0ADC5B25-8C0A-4F6E-AE0C-83A3089CCEE223963infoc&platform=android&sign=153cb8fda95e5b1400cc3729d9a8afce")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoPlayer> getVideoPlayer();
}
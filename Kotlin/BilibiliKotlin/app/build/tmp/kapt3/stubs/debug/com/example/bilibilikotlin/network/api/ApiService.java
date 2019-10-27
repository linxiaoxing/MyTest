package com.example.bilibilikotlin.network.api;

import java.lang.System;

/**
 * * 描述:番剧
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/bilibilikotlin/network/api/ApiService;", "", "getActivityCenter", "Lio/reactivex/Flowable;", "Lcom/example/bilibilikotlin/bean/discover/ActivityCenter;", "page", "", "pageSize", "getVideoDetailComment", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment;", "app_debug"})
public abstract interface ApiService {
    
    /**
     * 活动中心
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "event/getlist?device=phone&mobi_app=iphone")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.bean.discover.ActivityCenter> getActivityCenter(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "pagesize")
    int pageSize);
    
    /**
     * 视频评论
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/x/v2/reply?access_key=0e6adb874025dfabaa3ced3a7b22049d&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&oid=9938411&plat=2&platform=android&pn=1&ps=20&sort=0&ts=1497422373&type=1&sign=071c418a32ebc452e078308a04e1be4e")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoDetailComment> getVideoDetailComment();
}
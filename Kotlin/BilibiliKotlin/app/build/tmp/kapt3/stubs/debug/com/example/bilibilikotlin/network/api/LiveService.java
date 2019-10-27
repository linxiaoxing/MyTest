package com.example.bilibilikotlin.network.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0003H\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/bilibilikotlin/network/api/LiveService;", "", "getLiveEntrance", "Lio/reactivex/Flowable;", "Lcom/example/bilibilikotlin/network/response/HttpResponse;", "", "Lcom/example/bilibilikotlin/bean/live/LiveEntrance;", "getLivePartition", "Lcom/example/bilibilikotlin/bean/live/LivePartition;", "getLiveRecommend", "Lcom/example/bilibilikotlin/bean/live/LiveRecommend;", "app_debug"})
public abstract interface LiveService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/AppNewIndex/recommend?_device=android&access_key=5b0032c681c2233870c8edcee410b6c6&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xxhdpi&ts=1495639021&sign=9d024a5b09edddd51636d17d860622d2")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.network.response.HttpResponse<com.example.bilibilikotlin.bean.live.LiveRecommend>> getLiveRecommend();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/common.json")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.network.response.HttpResponse<com.example.bilibilikotlin.bean.live.LivePartition>> getLivePartition();
    
    /**
     * 获取直播分区的tag标题
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/AppIndex/areas?_device=android&access_key=21073183486ba556121c1160f107f0c5&appkey=1d8b6e7d45233436&build=506000&mobi_app=android&platform=android&scale=xxhdpi&ts=1496116760&sign=e2231dc84bc33bc1a7c6d8eddf13da9d")
    public abstract io.reactivex.Flowable<com.example.bilibilikotlin.network.response.HttpResponse<java.util.List<com.example.bilibilikotlin.bean.live.LiveEntrance>>> getLiveEntrance();
}
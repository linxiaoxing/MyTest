package com.example.bilibilikotlin.network.helper;

import java.lang.System;

/**
 * * 描述:RetrofitHelper 帮助类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\nJ\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\nJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\nJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;", "", "appService", "Lcom/example/bilibilikotlin/network/api/AppService;", "apiService", "Lcom/example/bilibilikotlin/network/api/ApiService;", "liveService", "Lcom/example/bilibilikotlin/network/api/LiveService;", "(Lcom/example/bilibilikotlin/network/api/AppService;Lcom/example/bilibilikotlin/network/api/ApiService;Lcom/example/bilibilikotlin/network/api/LiveService;)V", "getActivityCenter", "Lio/reactivex/Flowable;", "Lcom/example/bilibilikotlin/bean/discover/ActivityCenter;", "page", "", "pageSize", "getLivePartition", "Lcom/example/bilibilikotlin/network/response/HttpResponse;", "Lcom/example/bilibilikotlin/bean/live/LivePartition;", "getLiveRecommend", "Lcom/example/bilibilikotlin/bean/live/LiveRecommend;", "getSplash", "Lcom/example/bilibilikotlin/bean/app/Splash;", "getVideoDetail", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetail;", "getVideoDetailComment", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment;", "getVideoPlayer", "Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer;", "app_debug"})
public final class RetrofitHelper {
    private final com.example.bilibilikotlin.network.api.AppService appService = null;
    private final com.example.bilibilikotlin.network.api.ApiService apiService = null;
    private final com.example.bilibilikotlin.network.api.LiveService liveService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.Splash> getSplash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.bean.discover.ActivityCenter> getActivityCenter(int page, int pageSize) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.network.response.HttpResponse<com.example.bilibilikotlin.bean.live.LivePartition>> getLivePartition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.network.response.HttpResponse<com.example.bilibilikotlin.bean.live.LiveRecommend>> getLiveRecommend() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoDetail> getVideoDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoDetailComment> getVideoDetailComment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<com.example.bilibilikotlin.bean.app.video.VideoPlayer> getVideoPlayer() {
        return null;
    }
    
    public RetrofitHelper(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.AppService appService, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.api.LiveService liveService) {
        super();
    }
}
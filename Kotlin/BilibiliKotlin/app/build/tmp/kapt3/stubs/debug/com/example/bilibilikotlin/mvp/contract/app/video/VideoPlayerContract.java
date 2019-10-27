package com.example.bilibilikotlin.mvp.contract.app.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/video/VideoPlayerContract;", "", "Presenter", "View", "app_debug"})
public abstract interface VideoPlayerContract {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/video/VideoPlayerContract$View;", "Lcom/example/bilibilikotlin/base/BaseContract$BaseView;", "showAnimLoading", "", "showDanmaku", "baseDanmakuParser", "Lmaster/flame/danmaku/danmaku/parser/BaseDanmakuParser;", "showVideoPlayer", "videoPlayer", "Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer;", "app_debug"})
    public static abstract interface View extends com.example.bilibilikotlin.base.BaseContract.BaseView {
        
        public abstract void showVideoPlayer(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.app.video.VideoPlayer videoPlayer);
        
        public abstract void showAnimLoading();
        
        public abstract void showDanmaku(@org.jetbrains.annotations.NotNull()
        master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/video/VideoPlayerContract$Presenter;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "getVideoPlayerData", "", "app_debug"})
    public static abstract interface Presenter<T extends java.lang.Object> extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<T> {
        
        public abstract void getVideoPlayerData();
    }
}
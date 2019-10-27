package com.example.bilibilikotlin.mvp.contract.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/VideoDetailContract;", "", "Presenter", "View", "app_debug"})
public abstract interface VideoDetailContract {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/VideoDetailContract$View;", "Lcom/example/bilibilikotlin/base/BaseContract$BaseView;", "showVideoDetail", "", "videoDetail", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetail$DataBean;", "showVideoDetailComment", "videoDetailComment", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean;", "app_debug"})
    public static abstract interface View extends com.example.bilibilikotlin.base.BaseContract.BaseView {
        
        public abstract void showVideoDetail(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean videoDetail);
        
        public abstract void showVideoDetailComment(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean videoDetailComment);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/app/VideoDetailContract$Presenter;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "getVideoDetailData", "", "app_debug"})
    public static abstract interface Presenter<T extends java.lang.Object> extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<T> {
        
        public abstract void getVideoDetailData();
    }
}
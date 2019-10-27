package com.example.bilibilikotlin.mvp.contract.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract;", "", "Presenter", "View", "app_debug"})
public abstract interface LiveContract {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract$View;", "Lcom/example/bilibilikotlin/base/BaseContract$BaseView;", "showMulLive", "", "mulLives", "", "Lcom/example/bilibilikotlin/bean/live/MulLive;", "app_debug"})
    public static abstract interface View extends com.example.bilibilikotlin.base.BaseContract.BaseView {
        
        public abstract void showMulLive(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.bilibilikotlin.bean.live.MulLive> mulLives);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract$Presenter;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "getLiveData", "", "app_debug"})
    public static abstract interface Presenter<T extends java.lang.Object> extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<T> {
        
        public abstract void getLiveData();
    }
}
package com.example.bilibilikotlin.mvp.contract;

import java.lang.System;

/**
 * 描述:欢迎界面Contract
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/SplashContract;", "", "Presenter", "View", "app_debug"})
public abstract interface SplashContract {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/SplashContract$View;", "Lcom/example/bilibilikotlin/base/BaseContract$BaseView;", "showCountDown", "", "count", "", "showSplash", "splash", "Lcom/example/bilibilikotlin/bean/app/Splash;", "app_debug"})
    public static abstract interface View extends com.example.bilibilikotlin.base.BaseContract.BaseView {
        
        public abstract void showSplash(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.app.Splash splash);
        
        public abstract void showCountDown(int count);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/bilibilikotlin/mvp/contract/SplashContract$Presenter;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "getSplashData", "", "setCountDown", "app_debug"})
    public static abstract interface Presenter<T extends java.lang.Object> extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<T> {
        
        public abstract void getSplashData();
        
        public abstract void setCountDown();
    }
}
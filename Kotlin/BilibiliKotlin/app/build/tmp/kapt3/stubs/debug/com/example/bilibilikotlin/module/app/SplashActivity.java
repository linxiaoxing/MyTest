package com.example.bilibilikotlin.module.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/example/bilibilikotlin/module/app/SplashActivity;", "Lcom/trello/rxlifecycle2/components/support/RxAppCompatActivity;", "Lcom/example/bilibilikotlin/mvp/contract/SplashContract$View;", "()V", "mPresenter", "Lcom/example/bilibilikotlin/mvp/presenter/app/SplashPresenter;", "getMPresenter", "()Lcom/example/bilibilikotlin/mvp/presenter/app/SplashPresenter;", "setMPresenter", "(Lcom/example/bilibilikotlin/mvp/presenter/app/SplashPresenter;)V", "complete", "", "initInject", "initWidget", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "redirect", "showCountDown", "count", "", "showError", "msg", "", "showSplash", "splash", "Lcom/example/bilibilikotlin/bean/app/Splash;", "app_debug"})
public final class SplashActivity extends com.trello.rxlifecycle2.components.support.RxAppCompatActivity implements com.example.bilibilikotlin.mvp.contract.SplashContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.bilibilikotlin.mvp.presenter.app.SplashPresenter mPresenter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.mvp.presenter.app.SplashPresenter getMPresenter() {
        return null;
    }
    
    public final void setMPresenter(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.mvp.presenter.app.SplashPresenter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initInject() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * 跳转
     */
    public final void redirect() {
    }
    
    /**
     * 初始化组件
     */
    public final void initWidget() {
    }
    
    /**
     * 请求数据
     */
    public final void loadData() {
    }
    
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    @java.lang.Override()
    public void complete() {
    }
    
    @java.lang.Override()
    public void showSplash(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.app.Splash splash) {
    }
    
    @java.lang.Override()
    public void showCountDown(int count) {
    }
    
    public SplashActivity() {
        super();
    }
}
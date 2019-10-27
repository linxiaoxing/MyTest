package com.example.bilibilikotlin.base;

import java.lang.System;

/**
 * 基础Activity
 * Created by zzq on 2016/12/5.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u00028\u00008\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/example/bilibilikotlin/base/BaseInjectActivity;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "Lcom/example/bilibilikotlin/base/BaseActivity;", "Lcom/example/bilibilikotlin/base/BaseContract$BaseView;", "()V", "activityComponent", "Lcom/example/bilibilikotlin/di/component/ActivityComponent;", "getActivityComponent", "()Lcom/example/bilibilikotlin/di/component/ActivityComponent;", "activityModule", "Lcom/example/bilibilikotlin/di/module/ActivityModule;", "getActivityModule", "()Lcom/example/bilibilikotlin/di/module/ActivityModule;", "mPresenter", "getMPresenter", "()Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "setMPresenter", "(Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;)V", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "complete", "", "onDestroy", "showError", "msg", "", "app_debug"})
public abstract class BaseInjectActivity<T extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<?>> extends com.example.bilibilikotlin.base.BaseActivity implements com.example.bilibilikotlin.base.BaseContract.BaseView {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public T mPresenter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final T getMPresenter() {
        return null;
    }
    
    public final void setMPresenter(@org.jetbrains.annotations.NotNull()
    T p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.example.bilibilikotlin.di.module.ActivityModule getActivityModule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.example.bilibilikotlin.di.component.ActivityComponent getActivityComponent() {
        return null;
    }
    
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    @java.lang.Override()
    public void complete() {
    }
    
    /**
     * 销毁
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public BaseInjectActivity() {
        super();
    }
}
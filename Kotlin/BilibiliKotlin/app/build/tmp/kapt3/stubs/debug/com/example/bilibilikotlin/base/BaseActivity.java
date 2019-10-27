package com.example.bilibilikotlin.base;

import java.lang.System;

/**
 * 基础Activity
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH&J\u001f\u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 \u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010\'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u001f\u0010-\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 \u00a2\u0006\u0002\u0010!R\u0014\u0010\u0003\u001a\u00020\u0004X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2 = {"Lcom/example/bilibilikotlin/base/BaseActivity;", "Lcom/trello/rxlifecycle2/components/support/RxAppCompatActivity;", "()V", "mBack", "", "getMBack", "()Z", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mError", "Landroid/widget/LinearLayout;", "getMError", "()Landroid/widget/LinearLayout;", "setMError", "(Landroid/widget/LinearLayout;)V", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "getMToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "finishTask", "", "getLayoutId", "", "gone", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "initDatas", "initInject", "initPresenter", "initStatusBar", "initToolbar", "initVariables", "initWidget", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "visible", "app_debug"})
public abstract class BaseActivity extends com.trello.rxlifecycle2.components.support.RxAppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private androidx.appcompat.widget.Toolbar mToolbar;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    private final boolean mBack = true;
    @org.jetbrains.annotations.Nullable()
    private android.widget.LinearLayout mError;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.appcompat.widget.Toolbar getMToolbar() {
        return null;
    }
    
    protected final void setMToolbar(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.Toolbar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    protected final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    protected boolean getMBack() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.widget.LinearLayout getMError() {
        return null;
    }
    
    protected final void setMError(@org.jetbrains.annotations.Nullable()
    android.widget.LinearLayout p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 布局文件
     * @return 布局文件
     */
    public abstract int getLayoutId();
    
    /**
     * 注入依赖
     */
    public void initInject() {
    }
    
    /**
     * 完成请求
     */
    public void finishTask() {
    }
    
    /**
     * 初始化StatusBar
     */
    public void initStatusBar() {
    }
    
    /**
     * 初始化Presenter
     */
    public void initPresenter() {
    }
    
    /**
     * 初始化变量
     */
    public void initVariables() {
    }
    
    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
    }
    
    /**
     * 初始化控件
     */
    public void initWidget() {
    }
    
    /**
     * 加载数据
     */
    public void loadData() {
    }
    
    /**
     * 初始化数据
     */
    public void initDatas() {
    }
    
    /**
     * 隐藏View
     * @param views 视图
     */
    public final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    /**
     * 显示View
     * @param views 视图
     */
    public final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    public BaseActivity() {
        super();
    }
}
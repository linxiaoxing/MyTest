package com.example.bilibilikotlin.base;

import java.lang.System;

/**
 * * 描述:基础刷新的Fragment
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0014J\b\u0010\"\u001a\u00020 H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020 H\u0014J\b\u0010\'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0014J\b\u0010)\u001a\u00020 H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/example/bilibilikotlin/base/BaseRefreshFragment;", "T", "Lcom/example/bilibilikotlin/base/BaseContract$BasePresenter;", "K", "Lcom/example/bilibilikotlin/base/BaseInjectFragment;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "mIsRefreshing", "", "getMIsRefreshing", "()Z", "setMIsRefreshing", "(Z)V", "mList", "", "getMList", "()Ljava/util/List;", "setMList", "(Ljava/util/List;)V", "mRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRefresh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getMRefresh", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setMRefresh", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "clear", "", "clearData", "complete", "finishCreateView", "state", "Landroid/os/Bundle;", "initRefreshLayout", "initWidget", "lazyLoad", "onRefresh", "app_debug"})
public abstract class BaseRefreshFragment<T extends com.example.bilibilikotlin.base.BaseContract.BasePresenter<?>, K extends java.lang.Object> extends com.example.bilibilikotlin.base.BaseInjectFragment<T> implements androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView mRecycler;
    @org.jetbrains.annotations.Nullable()
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout mRefresh;
    private boolean mIsRefreshing;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<K> mList;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.recyclerview.widget.RecyclerView getMRecycler() {
        return null;
    }
    
    protected final void setMRecycler(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getMRefresh() {
        return null;
    }
    
    protected final void setMRefresh(@org.jetbrains.annotations.Nullable()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    protected final boolean getMIsRefreshing() {
        return false;
    }
    
    protected final void setMIsRefreshing(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.List<K> getMList() {
        return null;
    }
    
    protected final void setMList(@org.jetbrains.annotations.NotNull()
    java.util.List<K> p0) {
    }
    
    @java.lang.Override()
    protected void initRefreshLayout() {
    }
    
    @java.lang.Override()
    public void onRefresh() {
    }
    
    @java.lang.Override()
    protected void clearData() {
    }
    
    @java.lang.Override()
    public void finishCreateView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle state) {
    }
    
    @java.lang.Override()
    protected void lazyLoad() {
    }
    
    @java.lang.Override()
    public void complete() {
    }
    
    protected void clear() {
    }
    
    @java.lang.Override()
    public void initWidget() {
    }
    
    public BaseRefreshFragment() {
        super();
    }
}
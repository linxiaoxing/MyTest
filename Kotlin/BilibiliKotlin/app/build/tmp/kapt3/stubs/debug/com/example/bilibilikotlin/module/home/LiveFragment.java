package com.example.bilibilikotlin.module.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/bilibilikotlin/module/home/LiveFragment;", "Lcom/example/bilibilikotlin/base/BaseRefreshFragment;", "Lcom/example/bilibilikotlin/mvp/presenter/live/LivePresenter;", "Lcom/example/bilibilikotlin/bean/live/MulLive;", "Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract$View;", "()V", "mAdapter", "Lcom/example/bilibilikotlin/adapter/home/live/LiveAdapter;", "finishTask", "", "getLayoutId", "", "initInject", "initPresenter", "initRecyclerView", "lazyLoadData", "showMulLive", "mulLives", "", "Companion", "app_debug"})
public final class LiveFragment extends com.example.bilibilikotlin.base.BaseRefreshFragment<com.example.bilibilikotlin.mvp.presenter.live.LivePresenter, com.example.bilibilikotlin.bean.live.MulLive> implements com.example.bilibilikotlin.mvp.contract.home.LiveContract.View {
    private com.example.bilibilikotlin.adapter.home.live.LiveAdapter mAdapter;
    public static final com.example.bilibilikotlin.module.home.LiveFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    protected void lazyLoadData() {
    }
    
    @java.lang.Override()
    protected void initPresenter() {
    }
    
    @java.lang.Override()
    protected void initInject() {
    }
    
    @java.lang.Override()
    protected void initRecyclerView() {
    }
    
    @java.lang.Override()
    protected void finishTask() {
    }
    
    @java.lang.Override()
    public void showMulLive(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.live.MulLive> mulLives) {
    }
    
    public LiveFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bilibilikotlin/module/home/LiveFragment$Companion;", "", "()V", "newInstance", "Lcom/example/bilibilikotlin/module/home/LiveFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.module.home.LiveFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
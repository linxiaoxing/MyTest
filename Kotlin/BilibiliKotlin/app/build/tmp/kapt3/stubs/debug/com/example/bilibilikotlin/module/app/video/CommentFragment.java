package com.example.bilibilikotlin.module.app.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/bilibilikotlin/module/app/video/CommentFragment;", "Lcom/example/bilibilikotlin/base/BaseInjectFragment;", "Lcom/example/bilibilikotlin/mvp/presenter/app/video/CommentPresenter;", "Lcom/example/bilibilikotlin/mvp/contract/app/video/CommentContract$View;", "()V", "mAdapter", "Lcom/example/bilibilikotlin/adapter/app/video/CommentAdapter;", "mList", "", "Lcom/example/bilibilikotlin/bean/app/video/MulComment;", "finishTask", "", "getLayoutId", "", "initInject", "initPresenter", "initRecyclerView", "initWidget", "loadData", "showComment", "mulComments", "", "Companion", "app_debug"})
public final class CommentFragment extends com.example.bilibilikotlin.base.BaseInjectFragment<com.example.bilibilikotlin.mvp.presenter.app.video.CommentPresenter> implements com.example.bilibilikotlin.mvp.contract.app.video.CommentContract.View {
    private com.example.bilibilikotlin.adapter.app.video.CommentAdapter mAdapter;
    private final java.util.List<com.example.bilibilikotlin.bean.app.video.MulComment> mList = null;
    public static final com.example.bilibilikotlin.module.app.video.CommentFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    protected void initInject() {
    }
    
    @java.lang.Override()
    protected void initPresenter() {
    }
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    @java.lang.Override()
    public void initWidget() {
    }
    
    @java.lang.Override()
    protected void initRecyclerView() {
    }
    
    @java.lang.Override()
    public void showComment(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.app.video.MulComment> mulComments) {
    }
    
    @java.lang.Override()
    protected void finishTask() {
    }
    
    public CommentFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bilibilikotlin/module/app/video/CommentFragment$Companion;", "", "()V", "newInstance", "Lcom/example/bilibilikotlin/module/app/video/CommentFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.module.app.video.CommentFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
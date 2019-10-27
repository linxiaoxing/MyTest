package com.example.bilibilikotlin.module.app.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/bilibilikotlin/module/app/video/VideoDetailActivity;", "Lcom/example/bilibilikotlin/module/region/BaseRegionActivity;", "Lcom/example/bilibilikotlin/mvp/presenter/app/video/VideoDetailPresenter;", "Ljavax/annotation/Nullable;", "Lcom/example/bilibilikotlin/mvp/contract/app/VideoDetailContract$View;", "()V", "mVideoDetail", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetail$DataBean;", "mVideoDetailComment", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean;", "state", "Lcom/example/bilibilikotlin/module/app/video/VideoDetailActivity$CollapsingToolbarLayoutState;", "complete", "", "finishTask", "getLayoutId", "", "initAppBar", "initEvent", "initFAB", "initFragment", "initInject", "initPresenter", "initStatusBar", "initTitle", "initToolbar", "initViewPager", "initWidget", "loadData", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "setViewsTranslation", "target", "showError", "msg", "", "showVideoDetail", "videoDetail", "showVideoDetailComment", "videoDetailComment", "CollapsingToolbarLayoutState", "app_debug"})
public final class VideoDetailActivity extends com.example.bilibilikotlin.module.region.BaseRegionActivity<com.example.bilibilikotlin.mvp.presenter.app.video.VideoDetailPresenter, javax.annotation.Nullable> implements com.example.bilibilikotlin.mvp.contract.app.VideoDetailContract.View {
    private com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean mVideoDetail;
    private com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean mVideoDetailComment;
    private com.example.bilibilikotlin.module.app.video.VideoDetailActivity.CollapsingToolbarLayoutState state;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    public void showVideoDetail(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean videoDetail) {
    }
    
    @java.lang.Override()
    public void showVideoDetailComment(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean videoDetailComment) {
    }
    
    @java.lang.Override()
    public void loadData() {
    }
    
    @java.lang.Override()
    public void initInject() {
    }
    
    @java.lang.Override()
    public void initPresenter() {
    }
    
    @java.lang.Override()
    public void finishTask() {
    }
    
    @java.lang.Override()
    protected void initEvent() {
    }
    
    @java.lang.Override()
    protected void initTitle() {
    }
    
    @java.lang.Override()
    protected void initFragment() {
    }
    
    @java.lang.Override()
    protected void initViewPager() {
    }
    
    @java.lang.Override()
    public void initToolbar() {
    }
    
    @java.lang.Override()
    public void initStatusBar() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    /**
     * 设置FAB动画
     * @param target
     */
    private final void setViewsTranslation(int target) {
    }
    
    @java.lang.Override()
    public void initWidget() {
    }
    
    private final void initFAB() {
    }
    
    private final void initAppBar() {
    }
    
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    @java.lang.Override()
    public void complete() {
    }
    
    public VideoDetailActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/example/bilibilikotlin/module/app/video/VideoDetailActivity$CollapsingToolbarLayoutState;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "INTERNEDIATE", "app_debug"})
    static enum CollapsingToolbarLayoutState {
        /*public static final*/ EXPANDED /* = new EXPANDED() */,
        /*public static final*/ COLLAPSED /* = new COLLAPSED() */,
        /*public static final*/ INTERNEDIATE /* = new INTERNEDIATE() */;
        
        CollapsingToolbarLayoutState() {
        }
    }
}
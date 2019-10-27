package com.example.bilibilikotlin.module.app.video;

import java.lang.System;

/**
 * * 描述:视频播放界面
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0003J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010\'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0014J\b\u0010*\u001a\u00020\u001eH\u0014J\b\u0010+\u001a\u00020\u001eH\u0014J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/example/bilibilikotlin/module/app/video/VideoPlayerActivity;", "Lcom/example/bilibilikotlin/base/BaseInjectActivity;", "Lcom/example/bilibilikotlin/mvp/presenter/app/video/VideoPlayerPresenter;", "Lcom/example/bilibilikotlin/media/callback/DanmukuSwitchListener;", "Lcom/example/bilibilikotlin/media/callback/VideoBackListener;", "Lcom/example/bilibilikotlin/mvp/contract/app/video/VideoPlayerContract$View;", "()V", "danmakuContext", "Lmaster/flame/danmaku/danmaku/model/android/DanmakuContext;", "mLastPosition", "", "mLoadingAnim", "Landroid/graphics/drawable/AnimationDrawable;", "mMaxLinesPair", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mOverlappingEnablePair", "", "mStartText", "", "onCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onControllerEventsListener", "Lcom/example/bilibilikotlin/media/VideoPlayerView$OnControllerEventsListener;", "onInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "onSeekCompleteListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "back", "", "getLayoutId", "initAnimation", "initDanmaku", "initInject", "initMediaPlayer", "initPresenter", "initToolbar", "initWidget", "loadData", "onBackPressed", "onDestroy", "onPause", "onResume", "setDanmakushow", "isShow", "showAnimLoading", "showDanmaku", "baseDanmakuParser", "Lmaster/flame/danmaku/danmaku/parser/BaseDanmakuParser;", "showError", "msg", "showVideoPlayer", "videoPlayer", "Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer;", "app_debug"})
public final class VideoPlayerActivity extends com.example.bilibilikotlin.base.BaseInjectActivity<com.example.bilibilikotlin.mvp.presenter.app.video.VideoPlayerPresenter> implements com.example.bilibilikotlin.media.callback.DanmukuSwitchListener, com.example.bilibilikotlin.media.callback.VideoBackListener, com.example.bilibilikotlin.mvp.contract.app.video.VideoPlayerContract.View {
    private master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext;
    private java.lang.String mStartText;
    private android.graphics.drawable.AnimationDrawable mLoadingAnim;
    private long mLastPosition;
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> mMaxLinesPair;
    private java.util.HashMap<java.lang.Integer, java.lang.Boolean> mOverlappingEnablePair;
    
    /**
     * 视频缓冲事件回调
     */
    private final tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener = null;
    
    /**
     * 视频跳转事件回调
     */
    private final tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = null;
    
    /**
     * 视频播放完成事件回调
     */
    private final tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener = null;
    
    /**
     * 控制条控制状态事件回调
     */
    private final com.example.bilibilikotlin.media.VideoPlayerView.OnControllerEventsListener onControllerEventsListener = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initWidget() {
    }
    
    private final void initDanmaku() {
    }
    
    @java.lang.Override()
    public void initToolbar() {
    }
    
    @android.annotation.SuppressLint(value = {"UseSparseArrays"})
    private final void initMediaPlayer() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * 弹幕开关回调
     * @param isShow
     */
    @java.lang.Override()
    public void setDanmakushow(boolean isShow) {
    }
    
    /**
     * 退出界面回调
     */
    @java.lang.Override()
    public void back() {
    }
    
    @java.lang.Override()
    public void initInject() {
    }
    
    @java.lang.Override()
    public void initPresenter() {
    }
    
    @java.lang.Override()
    public void loadData() {
    }
    
    @java.lang.Override()
    public void showVideoPlayer(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.app.video.VideoPlayer videoPlayer) {
    }
    
    @java.lang.Override()
    public void showDanmaku(@org.jetbrains.annotations.NotNull()
    master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser) {
    }
    
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    @java.lang.Override()
    public void showAnimLoading() {
    }
    
    /**
     * 初始化加载动画
     */
    private final void initAnimation() {
    }
    
    public VideoPlayerActivity() {
        super();
    }
}
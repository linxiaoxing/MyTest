package com.example.gsygithubappkotlin.common.gsyimageloader.gsygiideloader;

import java.lang.System;

/**
 * Glide 图片下载对象
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/gsygiideloader/GSYImageDownLoadTarget;", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Ljava/io/File;", "mCallback", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$Callback;", "(Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$Callback;)V", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onLoadStarted", "placeholder", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_debug"})
public final class GSYImageDownLoadTarget extends com.bumptech.glide.request.target.SimpleTarget<java.io.File> {
    private final com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback mCallback = null;
    
    @java.lang.Override()
    public void onResourceReady(@org.jetbrains.annotations.NotNull()
    java.io.File resource, @org.jetbrains.annotations.Nullable()
    com.bumptech.glide.request.transition.Transition<? super java.io.File> transition) {
    }
    
    @java.lang.Override()
    public void onLoadStarted(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder) {
    }
    
    @java.lang.Override()
    public void onLoadFailed(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable errorDrawable) {
    }
    
    public GSYImageDownLoadTarget(@org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback mCallback) {
        super();
    }
}
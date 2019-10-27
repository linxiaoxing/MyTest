package com.example.gsygithubappkotlin.common.gsyimageloader;

import java.lang.System;

/**
 * 图片加载配置
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\'\u001a\u00020\u000bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0014J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0001J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R!\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001aj\b\u0012\u0004\u0012\u00020\u0001`\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006/"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYLoadOption;", "", "()V", "isCircle", "", "()Z", "setCircle", "(Z)V", "isPlayGif", "setPlayGif", "mDefaultImg", "", "getMDefaultImg", "()I", "setMDefaultImg", "(I)V", "mErrorImg", "getMErrorImg", "setMErrorImg", "mSize", "Landroid/graphics/Point;", "getMSize", "()Landroid/graphics/Point;", "setMSize", "(Landroid/graphics/Point;)V", "mTransformations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMTransformations", "()Ljava/util/ArrayList;", "mUri", "getMUri", "()Ljava/lang/Object;", "setMUri", "(Ljava/lang/Object;)V", "circle", "setDefaultImg", "defaultImg", "setErrorImg", "errorImg", "playGif", "setSize", "size", "setTransformations", "transform", "setUri", "uri", "app_debug"})
public final class GSYLoadOption {
    private int mDefaultImg;
    private int mErrorImg;
    private boolean isCircle;
    private boolean isPlayGif;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Point mSize;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object mUri;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.Object> mTransformations = null;
    
    public final int getMDefaultImg() {
        return 0;
    }
    
    public final void setMDefaultImg(int p0) {
    }
    
    public final int getMErrorImg() {
        return 0;
    }
    
    public final void setMErrorImg(int p0) {
    }
    
    public final boolean isCircle() {
        return false;
    }
    
    public final void setCircle(boolean p0) {
    }
    
    public final boolean isPlayGif() {
        return false;
    }
    
    public final void setPlayGif(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Point getMSize() {
        return null;
    }
    
    public final void setMSize(@org.jetbrains.annotations.Nullable()
    android.graphics.Point p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMUri() {
        return null;
    }
    
    public final void setMUri(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Object> getMTransformations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setDefaultImg(int defaultImg) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setErrorImg(int errorImg) {
        return null;
    }
    
    /**
     * 是否圆形，目前支持fresco 、 glide
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setCircle(boolean circle) {
        return null;
    }
    
    /**
     * 是否播放gif，只支持Fresco目前
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setPlayGif(boolean playGif) {
        return null;
    }
    
    /**
     * 目标尺寸
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setSize(@org.jetbrains.annotations.Nullable()
    android.graphics.Point size) {
        return null;
    }
    
    /**
     * 播放目标 string、uri、int
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setUri(@org.jetbrains.annotations.NotNull()
    java.lang.Object uri) {
        return null;
    }
    
    /**
     * 图片处理
     * picasso https://github.com/wasabeef/picasso-transformations
     * glide   https://github.com/wasabeef/glide-transformations
     * fresco  https://github.com/wasabeef/fresco-processors
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption setTransformations(@org.jetbrains.annotations.NotNull()
    java.lang.Object transform) {
        return null;
    }
    
    public GSYLoadOption() {
        super();
    }
}
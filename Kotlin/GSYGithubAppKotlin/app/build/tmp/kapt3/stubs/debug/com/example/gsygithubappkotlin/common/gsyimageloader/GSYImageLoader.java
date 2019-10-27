package com.example.gsygithubappkotlin.common.gsyimageloader;

import java.lang.System;

/**
 * 图片加载接口
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0019\u001aJ\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J0\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u001b"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader;", "", "clearCache", "", "type", "", "clearCacheKey", "loadOption", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYLoadOption;", "downloadOnly", "callback", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$Callback;", "extendOption", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$ExtendedOptions;", "getCacheSize", "", "()Ljava/lang/Long;", "getLocalCache", "Ljava/io/File;", "getLocalCacheBitmap", "Landroid/graphics/Bitmap;", "isCache", "", "loadImage", "target", "Callback", "ExtendedOptions", "app_debug"})
public abstract interface GSYImageLoader {
    
    /**
     * 加载图片
     * @param loadOption 加载图片配置
     * @param target 加载目标对象，ImageView or SimpleDraweeView
     * @param callback 加载回调
     * @param extendOption 额外配置接口
     */
    public abstract void loadImage(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    java.lang.Object target, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback callback, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption);
    
    /**
     * 清除缓存
     * @param type GSYImageConst，清除类型
     */
    public abstract void clearCache(int type);
    
    /**
     * 清除指定缓存
     * @param type GSYImageConst，清除类型
     * @param loadOption 加载图片配置
     */
    public abstract void clearCacheKey(int type, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption);
    
    /**
     * 是否已经缓存到本地
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return Boolean 是否已经缓存到本地
     */
    public abstract boolean isCache(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption);
    
    /**
     * 获取本地缓存
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return File
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.io.File getLocalCache(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption);
    
    /**
     * 获取本地缓存bitmap
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return Bitmap
     */
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.Bitmap getLocalCacheBitmap(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption);
    
    /**
     * 获取本地缓存大小
     * @return Long
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Long getCacheSize();
    
    /**
     * 下载图片
     * @param loadOption 加载图片配置
     * @param callback 加载回调
     * @param extendOption 额外配置接口
     * @return Bitmap
     */
    public abstract void downloadOnly(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback callback, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption);
    
    /**
     * 额外配置支持
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$ExtendedOptions;", "", "onOptionsInit", "", "option", "app_debug"})
    public static abstract interface ExtendedOptions {
        
        /**
         * @param option 配置对象
         * Glide    com.bumptech.glide.request.RequestOptions
         * Picasso  com.squareup.picasso.RequestCreator
         * Fresco   com.facebook.imagepipeline.request.ImageRequestBuilder
         */
        public abstract void onOptionsInit(@org.jetbrains.annotations.Nullable()
        java.lang.Object option);
    }
    
    /**
     * 回调接口
     */
    @androidx.annotation.UiThread()
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\n"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$Callback;", "", "onFail", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onStart", "onSuccess", "result", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onStart();
        
        public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
        java.lang.Object result);
        
        public abstract void onFail(@org.jetbrains.annotations.Nullable()
        java.lang.Exception error);
    }
    
    /**
     * 图片加载接口
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}
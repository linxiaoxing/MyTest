package com.example.gsygithubappkotlin.common.gsyimageloader;

import java.lang.System;

/**
 * 图片加载管理
 * Created by guoshuyu on 2018/1/18.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0006\u0010\u0017\u001a\u00020\u0001J\u0015\u0010\u0018\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u0001\u00a2\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J1\u0010\u001d\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoaderManager;", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader;", "mImageLoader", "(Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader;)V", "clearCache", "", "type", "", "clearCacheKey", "loadOption", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYLoadOption;", "downloadOnly", "callback", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$Callback;", "extendOption", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader$ExtendedOptions;", "getCacheSize", "", "()Ljava/lang/Long;", "getLocalCache", "Ljava/io/File;", "getLocalCacheBitmap", "Landroid/graphics/Bitmap;", "imageLoader", "imageLoaderExtend", "T", "()Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader;", "isCache", "", "loadImage", "target", "", "Companion", "app_debug"})
public final class GSYImageLoaderManager implements com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader {
    private com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader mImageLoader;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.properties.ReadWriteProperty sInstance$delegate = null;
    public static final com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoaderManager.Companion Companion = null;
    
    /**
     * 图片加载对象
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader imageLoader() {
        return null;
    }
    
    /**
     * 强制转换的图片加载对象
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader>T imageLoaderExtend() {
        return null;
    }
    
    private GSYImageLoaderManager(com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader mImageLoader) {
        super();
    }
    
    /**
     * 清除缓存
     * @param type GSYImageConst，清除类型
     */
    @java.lang.Override()
    public void clearCache(int type) {
    }
    
    /**
     * 清除指定缓存
     * @param type GSYImageConst，清除类型
     * @param loadOption 加载图片配置
     */
    @java.lang.Override()
    public void clearCacheKey(int type, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption) {
    }
    
    /**
     * 下载图片
     * @param loadOption 加载图片配置
     * @param callback 加载回调
     * @param extendOption 额外配置接口
     * @return Bitmap
     */
    @java.lang.Override()
    public void downloadOnly(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback callback, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption) {
    }
    
    /**
     * 获取本地缓存大小
     * @return Long
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getCacheSize() {
        return null;
    }
    
    /**
     * 获取本地缓存
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return File
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.io.File getLocalCache(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption) {
        return null;
    }
    
    /**
     * 获取本地缓存bitmap
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return Bitmap
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.Bitmap getLocalCacheBitmap(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption) {
        return null;
    }
    
    /**
     * 是否已经缓存到本地
     * @param loadOption 加载图片配置
     * @param extendOption 额外配置接口
     * @return Boolean 是否已经缓存到本地
     */
    @java.lang.Override()
    public boolean isCache(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption) {
        return false;
    }
    
    /**
     * 加载图片
     * @param loadOption 加载图片配置
     * @param target 加载目标对象，ImageView or SimpleDraweeView
     * @param callback 加载回调
     * @param extendOption 额外配置接口
     */
    @java.lang.Override()
    public void loadImage(@org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYLoadOption loadOption, @org.jetbrains.annotations.Nullable()
    java.lang.Object target, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.Callback callback, @org.jetbrains.annotations.Nullable()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader.ExtendedOptions extendOption) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoaderManager$Companion;", "", "()V", "<set-?>", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoaderManager;", "sInstance", "getSInstance", "()Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoaderManager;", "setSInstance", "(Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoaderManager;)V", "sInstance$delegate", "Lkotlin/properties/ReadWriteProperty;", "initialize", "", "imageLoader", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYImageLoader;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoaderManager getSInstance() {
            return null;
        }
        
        public final void setSInstance(@org.jetbrains.annotations.NotNull()
        com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoaderManager p0) {
        }
        
        /**
         * 静态初始化、建议Application中初始化
         * @param imageLoader 内含GSYPicassoImageLoader、GSYFrescoImageLoader、GSYPicassoImageLoader
         */
        public final void initialize(@org.jetbrains.annotations.NotNull()
        com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoader imageLoader) {
        }
        
        private Companion() {
            super();
        }
    }
}
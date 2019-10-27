package com.example.gsykotlin.common.net;

import java.lang.System;

/**
 * 网络请求
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t\u00a8\u0006 "}, d2 = {"Lcom/example/gsykotlin/common/net/RetrofitFactory;", "", "()V", "<set-?>", "", "accessTokenStorage", "getAccessTokenStorage", "()Ljava/lang/String;", "setAccessTokenStorage", "(Ljava/lang/String;)V", "accessTokenStorage$delegate", "Lcom/example/gsykotlin/common/utils/GSYPreference;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "userBasicCodeStorage", "getUserBasicCodeStorage", "setUserBasicCodeStorage", "userBasicCodeStorage$delegate", "excuteResult", "", "T", "observable", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "subscriber", "Lcom/example/gsykotlin/common/net/ResultObserver;", "getAuthorization", "headerInterceptor", "Lokhttp3/Interceptor;", "Companion", "app_debug"})
public final class RetrofitFactory {
    private final com.example.gsykotlin.common.utils.GSYPreference accessTokenStorage$delegate = null;
    private final com.example.gsykotlin.common.utils.GSYPreference userBasicCodeStorage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final retrofit2.Retrofit retrofit = null;
    private static volatile com.example.gsykotlin.common.net.RetrofitFactory mRetrofitFactory;
    public static final com.example.gsykotlin.common.net.RetrofitFactory.Companion Companion = null;
    
    private final java.lang.String getAccessTokenStorage() {
        return null;
    }
    
    private final void setAccessTokenStorage(java.lang.String p0) {
    }
    
    private final java.lang.String getUserBasicCodeStorage() {
        return null;
    }
    
    private final void setUserBasicCodeStorage(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    /**
     * 拦截头部增加token
     */
    private final okhttp3.Interceptor headerInterceptor() {
        return null;
    }
    
    /**
     * 获取token
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorization() {
        return null;
    }
    
    /**
     * 执行请求返回结果
     */
    public final <T extends java.lang.Object>void excuteResult(@org.jetbrains.annotations.NotNull()
    io.reactivex.Observable<retrofit2.Response<T>> observable, @org.jetbrains.annotations.NotNull()
    com.example.gsykotlin.common.net.ResultObserver<T> subscriber) {
    }
    
    private RetrofitFactory() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/gsykotlin/common/net/RetrofitFactory$Companion;", "", "()V", "instance", "Lcom/example/gsykotlin/common/net/RetrofitFactory;", "getInstance", "()Lcom/example/gsykotlin/common/net/RetrofitFactory;", "mRetrofitFactory", "createService", "T", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gsykotlin.common.net.RetrofitFactory getInstance() {
            return null;
        }
        
        public final <T extends java.lang.Object>T createService(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> service) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
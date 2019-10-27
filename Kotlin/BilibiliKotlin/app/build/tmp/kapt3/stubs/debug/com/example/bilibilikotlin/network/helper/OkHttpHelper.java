package com.example.bilibilikotlin.network.helper;

import java.lang.System;

/**
 * 全局统一使用的OkHttpClient工具，okhttp版本：okhttp3
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/example/bilibilikotlin/network/helper/OkHttpHelper;", "", "()V", "CACHE_STALE_LONG", "", "getCACHE_STALE_LONG", "()J", "DEFAULT_CONNECT_TIMEOUT_MILLIS", "getDEFAULT_CONNECT_TIMEOUT_MILLIS", "DEFAULT_READ_TIMEOUT_MILLIS", "getDEFAULT_READ_TIMEOUT_MILLIS", "DEFAULT_WRITE_TIMEOUT_MILLIS", "getDEFAULT_WRITE_TIMEOUT_MILLIS", "HTTP_RESPONSE_DISK_CACHE_MAX_SIZE", "mOkHttpClient", "Lokhttp3/OkHttpClient;", "getMOkHttpClient", "()Lokhttp3/OkHttpClient;", "setMOkHttpClient", "(Lokhttp3/OkHttpClient;)V", "getCache", "Lokhttp3/Cache;", "context", "Landroid/content/Context;", "getOkHttpClient", "setCache", "", "RewriteCacheControlInterceptor", "UserAgentInterceptor", "app_debug"})
public final class OkHttpHelper {
    @org.jetbrains.annotations.NotNull()
    private static volatile okhttp3.OkHttpClient mOkHttpClient;
    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 20000L;
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20000L;
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20000L;
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 20000000L;
    private static final long CACHE_STALE_LONG = 604800L;
    public static final com.example.bilibilikotlin.network.helper.OkHttpHelper INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient getMOkHttpClient() {
        return null;
    }
    
    public final void setMOkHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient p0) {
    }
    
    public final long getDEFAULT_READ_TIMEOUT_MILLIS() {
        return 0L;
    }
    
    public final long getDEFAULT_WRITE_TIMEOUT_MILLIS() {
        return 0L;
    }
    
    public final long getDEFAULT_CONNECT_TIMEOUT_MILLIS() {
        return 0L;
    }
    
    public final long getCACHE_STALE_LONG() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    /**
     * 设置缓存路径
     * @param context 上下文
     */
    public final void setCache(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * 获取缓存路径
     * @return cache
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Cache getCache(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private OkHttpHelper() {
        super();
    }
    
    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/bilibilikotlin/network/helper/OkHttpHelper$UserAgentInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
    static final class UserAgentInterceptor implements okhttp3.Interceptor {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
        okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            return null;
        }
        
        public UserAgentInterceptor() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/bilibilikotlin/network/helper/OkHttpHelper$RewriteCacheControlInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
    static final class RewriteCacheControlInterceptor implements okhttp3.Interceptor {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
        okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            return null;
        }
        
        public RewriteCacheControlInterceptor() {
            super();
        }
    }
}
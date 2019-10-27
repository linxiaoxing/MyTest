package com.example.musicplayersam.repository.netease;

import java.lang.System;

/**
 * desc   : 改自 https://github.com/Binaryify/NeteaseCloudMusicApi/blob/master/util/util.js
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/musicplayersam/repository/netease/CloudMusicServiceProvider;", "", "()V", "URL_BASE", "", "cache", "Ljava/io/File;", "generateClient", "Lokhttp3/OkHttpClient;", "cookieStore", "Lcom/example/musicplayersam/utils/component/network/CookieStore;", "provideCloudMusicService", "Lcom/example/musicplayersam/repository/netease/CloudMusicService;", "app_debug"})
public final class CloudMusicServiceProvider {
    private static final java.lang.String URL_BASE = "http://music.163.com";
    private static final java.io.File cache = null;
    public static final com.example.musicplayersam.repository.netease.CloudMusicServiceProvider INSTANCE = null;
    
    /**
     * @param cookieStore 保存和取得 cookie 的载体
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.musicplayersam.repository.netease.CloudMusicService provideCloudMusicService(@org.jetbrains.annotations.Nullable()
    com.example.musicplayersam.utils.component.network.CookieStore cookieStore) {
        return null;
    }
    
    private final okhttp3.OkHttpClient generateClient(com.example.musicplayersam.utils.component.network.CookieStore cookieStore) {
        return null;
    }
    
    private CloudMusicServiceProvider() {
        super();
    }
}
package com.example.musicplayersam.repository.netease;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J8\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\'\u00a8\u0006 "}, d2 = {"Lcom/example/musicplayersam/repository/netease/CloudMusicService;", "", "dailySign", "Lkotlinx/coroutines/Deferred;", "Lcom/google/gson/JsonObject;", "request", "", "", "fmTrash", "id", "", "like", "", "login", "lyric", "musicDetail", "musicUrl", "mvDetail", "personalFm", "personalizedDj", "personalizedMv", "personalizedNewSong", "personalizedPlaylist", "playlistDetail", "recommendMv", "recommendPlaylist", "recommendSongs", "searchMusic", "subcount", "toplistDetail", "userDetail", "userPlayList", "app_debug"})
public abstract interface CloudMusicService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/search/get")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> searchMusic(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v3/song/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> musicDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/song/enhance/player/url")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> musicUrl(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/song/lyric?os=osx&lv=-1&kv=-1&tv=-1")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> lyric(@retrofit2.http.Query(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * login 不进行缓存
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/login/cellphone")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Cache-Control: max-age=0"})
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/user/playlist")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> userPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v1/discovery/recommend/songs")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> recommendSongs(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/point/dailyTask")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> dailySign(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v1/user/detail/{id}")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> userDetail(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v1/discovery/recommend/resource")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> recommendPlaylist(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/personalized/mv")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> recommendMv(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v3/playlist/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> playlistDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/mv/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> mvDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/v1/radio/get")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> personalFm(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/radio/like?alg=itembased&time=25")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> like(@retrofit2.http.Query(value = "trackId")
    long id, @retrofit2.http.Query(value = "like")
    boolean like, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/radio/trash/add?alg=RT&time=25")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> fmTrash(@retrofit2.http.Query(value = "songId")
    long id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 获取用户信息 , 歌单，收藏，mv, dj 数量
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/subcount")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> subcount(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 所有榜单内容摘要
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/toplist/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> toplistDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 推荐歌单
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/personalized/playlist")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> personalizedPlaylist(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 推荐新音乐
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/personalized/newsong")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> personalizedNewSong(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 主播电台
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/personalized/djprogram")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> personalizedDj(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
    
    /**
     * 推荐MV
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/weapi/personalized/mv")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<com.google.gson.JsonObject> personalizedMv(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> request);
}
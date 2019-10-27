package com.example.musicplayersam.utils.component.network;

import java.lang.System;

/**
 * desc   : 用于持续保存Cookie
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\nH\u0004J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0010H\u0004J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0004J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/example/musicplayersam/utils/component/network/CookieStore;", "", "()V", "add", "", "url", "Lokhttp3/HttpUrl;", "cookie", "Lokhttp3/Cookie;", "byteArrayToHexString", "", "bytes", "", "decodeCookie", "cookieString", "encodeCookie", "Lcom/example/musicplayersam/utils/component/network/SerializableOkHttpCookies;", "get", "", "getCookieToken", "getCookies", "hexStringToByteArray", "hexString", "remove", "", "removeAll", "app_debug"})
public abstract class CookieStore {
    
    public abstract void add(@org.jetbrains.annotations.NotNull()
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
    okhttp3.Cookie cookie);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<okhttp3.Cookie> get(@org.jetbrains.annotations.NotNull()
    okhttp3.HttpUrl url);
    
    public abstract boolean removeAll();
    
    public abstract boolean remove(@org.jetbrains.annotations.NotNull()
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
    okhttp3.Cookie cookie);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<okhttp3.Cookie> getCookies();
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getCookieToken(@org.jetbrains.annotations.NotNull()
    okhttp3.Cookie cookie) {
        return null;
    }
    
    /**
     * cookies 序列化成 string
     *
     * @param cookie 要序列化的cookie
     * @return 序列化之后的string
     */
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String encodeCookie(@org.jetbrains.annotations.NotNull()
    com.example.musicplayersam.utils.component.network.SerializableOkHttpCookies cookie) {
        return null;
    }
    
    /**
     * 将字符串反序列化成cookies
     *
     * @param cookieString cookies string
     * @return cookie object
     */
    @org.jetbrains.annotations.Nullable()
    protected final okhttp3.Cookie decodeCookie(@org.jetbrains.annotations.NotNull()
    java.lang.String cookieString) {
        return null;
    }
    
    /**
     * 二进制数组转十六进制字符串
     *
     * @param bytes byte array to be converted
     * @return string containing hex values
     */
    private final java.lang.String byteArrayToHexString(byte[] bytes) {
        return null;
    }
    
    /**
     * 十六进制字符串转二进制数组
     *
     * @param hexString string of hex-encoded values
     * @return decoded byte array
     */
    private final byte[] hexStringToByteArray(java.lang.String hexString) {
        return null;
    }
    
    public CookieStore() {
        super();
    }
}
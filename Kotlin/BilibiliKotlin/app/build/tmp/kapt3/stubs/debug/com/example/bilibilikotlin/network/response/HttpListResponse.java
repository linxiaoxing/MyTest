package com.example.bilibilikotlin.network.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/example/bilibilikotlin/network/response/HttpListResponse;", "T", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "result", "getResult", "setResult", "app_debug"})
public final class HttpListResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<? extends T> data;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<? extends T> result;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String message;
    private int code;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getCode() {
        return 0;
    }
    
    public final void setCode(int p0) {
    }
    
    public HttpListResponse() {
        super();
    }
}
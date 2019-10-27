package com.example.gsykotlin.common.net;

import java.lang.System;

/**
 * 网络请求返回处理
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0017\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Lcom/example/gsykotlin/common/net/ResultObserver;", "T", "Lio/reactivex/Observer;", "Lretrofit2/Response;", "()V", "onCodeError", "", "code", "", "message", "", "onComplete", "onError", "e", "", "onFailure", "isNetWorkError", "", "onInnerCodeError", "onNext", "reposnse", "onPageInfo", "first", "current", "last", "response", "onRequestEnd", "onRequestStart", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "result", "(Ljava/lang/Object;)V", "app_debug"})
public abstract class ResultObserver<T extends java.lang.Object> implements io.reactivex.Observer<retrofit2.Response<T>> {
    
    @java.lang.Override()
    public void onSubscribe(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable d) {
    }
    
    @java.lang.Override()
    public void onNext(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> reposnse) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    public void onInnerCodeError(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * 返回成功了,但是code错误
     *
     * @param t
     * @throws Exception
     */
    public void onCodeError(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) throws java.lang.Exception {
    }
    
    public void onRequestStart() {
    }
    
    public void onRequestEnd() {
    }
    
    public void onPageInfo(int first, int current, int last) {
    }
    
    public final void onPageInfo(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> response) {
    }
    
    /**
     * 返回成功
     *
     * @param result
     * @throws Exception
     */
    public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    T result);
    
    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    public abstract void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e, boolean isNetWorkError) throws java.lang.Exception;
    
    public ResultObserver() {
        super();
    }
}
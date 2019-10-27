package com.example.bilibilikotlin.rx;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a&\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a*\u0010\u0006\u001a \u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0007\"\u0004\b\u0000\u0010\u0002\u001a\u001e\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002\u001a\u0018\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002\u00a8\u0006\u000b"}, d2 = {"createData", "Lio/reactivex/Flowable;", "T", "t", "(Ljava/lang/Object;)Lio/reactivex/Flowable;", "", "handleListResult", "Lio/reactivex/FlowableTransformer;", "Lcom/example/bilibilikotlin/network/response/HttpResponse;", "handleResult", "rxSchedulerHelper", "app_debug"})
public final class RxUtilsKt {
    
    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.FlowableTransformer<T, T> rxSchedulerHelper() {
        return null;
    }
    
    /**
     * 生成Flowable
     * @param <T>
     * @return
     * </T>
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Flowable<T> createData(T t) {
        return null;
    }
    
    /**
     * 生成Flowable
     * @param <T>
     * @return <T>
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Flowable<java.util.List<T>> createData(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> t) {
        return null;
    }
    
    /**
     * 统一返回结果处理
     * @param <T>
     * *
     * @return
     * </T>
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.FlowableTransformer<com.example.bilibilikotlin.network.response.HttpResponse<T>, T> handleResult() {
        return null;
    }
    
    /**
     * 统一返回结果处理
     * @param <T>
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.FlowableTransformer<com.example.bilibilikotlin.network.response.HttpResponse<java.util.List<T>>, java.util.List<T>> handleListResult() {
        return null;
    }
}
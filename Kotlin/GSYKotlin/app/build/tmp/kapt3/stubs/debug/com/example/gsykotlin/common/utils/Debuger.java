package com.example.gsykotlin.common.utils;

import java.lang.System;

/**
 * debug输出
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/example/gsykotlin/common/utils/Debuger;", "", "()V", "LOG_TAG", "", "debugMode", "", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "Toast", "", "activity", "Landroid/app/Activity;", "log", "disable", "enable", "printfError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Tag", "printfLog", "tag", "printfWarning", "app_debug"})
public final class Debuger {
    private static final java.lang.String LOG_TAG = "GSYGithubAppKotlin";
    private static boolean debugMode;
    public static final com.example.gsykotlin.common.utils.Debuger INSTANCE = null;
    
    public final boolean getDebugMode() {
        return false;
    }
    
    public final void setDebugMode(boolean p0) {
    }
    
    public final void enable() {
    }
    
    public final void disable() {
    }
    
    public final void printfLog(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.Nullable()
    java.lang.String log) {
    }
    
    public final void printfLog(@org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    public final void printfWarning(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.Nullable()
    java.lang.String log) {
    }
    
    public final void printfWarning(@org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    public final void printfError(@org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    public final void printfError(@org.jetbrains.annotations.NotNull()
    java.lang.String Tag, @org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    public final void printfError(@org.jetbrains.annotations.NotNull()
    java.lang.String log, @org.jetbrains.annotations.NotNull()
    java.lang.Exception e) {
    }
    
    public final void Toast(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    private Debuger() {
        super();
    }
}
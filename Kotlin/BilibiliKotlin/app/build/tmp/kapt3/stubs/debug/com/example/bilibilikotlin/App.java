package com.example.bilibilikotlin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/example/bilibilikotlin/App;", "Landroid/app/Application;", "()V", "allActivities", "Ljava/util/HashSet;", "Landroid/app/Activity;", "Lkotlin/collections/HashSet;", "appComponent", "Lcom/example/bilibilikotlin/di/component/AppComponent;", "getAppComponent", "()Lcom/example/bilibilikotlin/di/component/AppComponent;", "appComponent$delegate", "Lkotlin/Lazy;", "addActivity", "", "act", "exitApp", "initCrashHandler", "initLog", "initNetwork", "initPrefs", "initStetho", "onCreate", "removeActivity", "Companion", "app_debug"})
public final class App extends android.app.Application {
    private java.util.HashSet<android.app.Activity> allActivities;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy appComponent$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static com.example.bilibilikotlin.App instance;
    public static final com.example.bilibilikotlin.App.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.di.component.AppComponent getAppComponent() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * 开启网络监听
     */
    private final void initNetwork() {
    }
    
    /**
     * 初始化log
     */
    private final void initLog() {
    }
    
    /**
     * 初始化调试
     */
    private final void initStetho() {
    }
    
    /**
     * 初始化崩溃日志
     */
    private final void initCrashHandler() {
    }
    
    /**
     * 初始化sp
     */
    private final void initPrefs() {
    }
    
    /**
     * 增加Activity
     * @param act act
     */
    public final void addActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity act) {
    }
    
    /**
     * 移除Activity
     * @param act act
     */
    public final void removeActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity act) {
    }
    
    /**
     * 退出应用
     */
    public final synchronized void exitApp() {
    }
    
    public App() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/App$Companion;", "", "()V", "instance", "Lcom/example/bilibilikotlin/App;", "getInstance", "()Lcom/example/bilibilikotlin/App;", "setInstance", "(Lcom/example/bilibilikotlin/App;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.App getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.App p0) {
        }
        
        private Companion() {
            super();
        }
    }
}
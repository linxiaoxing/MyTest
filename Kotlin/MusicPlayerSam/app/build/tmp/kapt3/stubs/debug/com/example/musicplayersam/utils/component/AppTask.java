package com.example.musicplayersam.utils.component;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/musicplayersam/utils/component/AppTask;", "", "()V", "activeActivities", "Landroid/util/ArraySet;", "Lcom/example/musicplayersam/ui/activity/base/BaseActivity;", "availableActivities", "value", "topStackActivity", "getTopStackActivity", "()Lcom/example/musicplayersam/ui/activity/base/BaseActivity;", "setTopStackActivity", "(Lcom/example/musicplayersam/ui/activity/base/BaseActivity;)V", "dumpStackInfo", "", "getActiveActivities", "getAvailableActivities", "CallBack", "app_debug"})
public final class AppTask {
    private static final android.util.ArraySet<com.example.musicplayersam.ui.activity.base.BaseActivity> activeActivities = null;
    private static final android.util.ArraySet<com.example.musicplayersam.ui.activity.base.BaseActivity> availableActivities = null;
    @org.jetbrains.annotations.Nullable()
    private static com.example.musicplayersam.ui.activity.base.BaseActivity topStackActivity;
    public static final com.example.musicplayersam.utils.component.AppTask INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.musicplayersam.ui.activity.base.BaseActivity getTopStackActivity() {
        return null;
    }
    
    private final void setTopStackActivity(com.example.musicplayersam.ui.activity.base.BaseActivity value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.util.ArraySet<com.example.musicplayersam.ui.activity.base.BaseActivity> getActiveActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.util.ArraySet<com.example.musicplayersam.ui.activity.base.BaseActivity> getAvailableActivities() {
        return null;
    }
    
    public final void dumpStackInfo() {
    }
    
    private AppTask() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/example/musicplayersam/utils/component/AppTask$CallBack;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "baseActivity", "Lcom/example/musicplayersam/ui/activity/base/BaseActivity;", "activity", "Landroid/app/Activity;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "app_debug"})
    public static final class CallBack implements android.app.Application.ActivityLifecycleCallbacks {
        public static final com.example.musicplayersam.utils.component.AppTask.CallBack INSTANCE = null;
        
        @java.lang.Override()
        public void onActivityCreated(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity, @org.jetbrains.annotations.Nullable()
        android.os.Bundle savedInstanceState) {
        }
        
        @java.lang.Override()
        public void onActivityStarted(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivityResumed(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivityPaused(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivityStopped(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivityDestroyed(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivitySaveInstanceState(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity, @org.jetbrains.annotations.Nullable()
        android.os.Bundle outState) {
        }
        
        private final com.example.musicplayersam.ui.activity.base.BaseActivity baseActivity(android.app.Activity activity) {
            return null;
        }
        
        private CallBack() {
            super();
        }
    }
}
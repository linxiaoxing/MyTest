package com.example.gsykotlin.common.utils;

import java.lang.System;

/**
 * SharedPreferences对象
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0086\u0002\u00a2\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0019\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0018\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u001aR\u0010\u0010\u0005\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/example/gsykotlin/common/utils/GSYPreference;", "T", "", "keyName", "", "default", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "getSharePreferences", "name", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "putSharePreferences", "", "value", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "app_debug"})
public final class GSYPreference<T extends java.lang.Object> {
    private final kotlin.Lazy prefs$delegate = null;
    private final java.lang.String keyName = null;
    
    private final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    public final T getValue(@org.jetbrains.annotations.Nullable()
    java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.Nullable()
    java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property, T value) {
    }
    
    private final void putSharePreferences(java.lang.String name, T value) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    private final T getSharePreferences(java.lang.String name, T p1_772401952) {
        return null;
    }
    
    public GSYPreference(@org.jetbrains.annotations.NotNull()
    java.lang.String keyName, T p1_772401952) {
        super();
    }
}
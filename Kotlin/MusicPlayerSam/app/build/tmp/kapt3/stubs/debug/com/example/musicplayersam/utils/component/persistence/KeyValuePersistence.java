package com.example.musicplayersam.utils.component.persistence;

import java.lang.System;

/**
 * save key value pair to persistence
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\f"}, d2 = {"Lcom/example/musicplayersam/utils/component/persistence/KeyValuePersistence;", "", "get", "T", "key", "", "typeofT", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "put", "", "any", "app_debug"})
public abstract interface KeyValuePersistence {
    
    /**
     * get value by key, might be null if value is empty or parse failed
     */
    @org.jetbrains.annotations.Nullable()
    public abstract <T extends java.lang.Object>T get(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.reflect.Type typeofT);
    
    /**
     * save key and value
     *
     * @param any null to remove the value
     */
    public abstract void put(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object any);
}
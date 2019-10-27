package com.example.musicplayersam.repository.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H%J\'\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H%J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/example/musicplayersam/repository/db/dao/KeyValueDao;", "Lcom/example/musicplayersam/utils/component/persistence/KeyValuePersistence;", "()V", "findEntity", "Lcom/example/musicplayersam/repository/db/entity/KeyValueEntity;", "key", "", "get", "T", "typeofT", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "insert", "", "objectWrapperEntity", "put", "any", "", "app_debug"})
public abstract class KeyValueDao implements com.example.musicplayersam.utils.component.persistence.KeyValuePersistence {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from objects where `key` == :key")
    protected abstract com.example.musicplayersam.repository.db.entity.KeyValueEntity findEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    protected abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.musicplayersam.repository.db.entity.KeyValueEntity objectWrapperEntity);
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public <T extends java.lang.Object>T get(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.reflect.Type typeofT) {
        return null;
    }
    
    @java.lang.Override()
    public void put(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object any) {
    }
    
    public KeyValueDao() {
        super();
    }
}
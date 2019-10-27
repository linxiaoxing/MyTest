package com.example.musicplayersam.repository.db;

import java.lang.System;

@androidx.room.Database(entities = {com.example.musicplayersam.repository.db.entity.LocalMusic.class, com.example.musicplayersam.repository.db.entity.KeyValueEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/musicplayersam/repository/db/QuietDatabase;", "Landroidx/room/RoomDatabase;", "()V", "keyValueDao", "Lcom/example/musicplayersam/repository/db/dao/KeyValueDao;", "localMusicDao", "Lcom/example/musicplayersam/repository/db/dao/LocalMusicDao;", "Companion", "app_debug"})
public abstract class QuietDatabase extends androidx.room.RoomDatabase {
    private static final java.lang.String DB_NAME = "quiet.db";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy instance$delegate = null;
    public static final com.example.musicplayersam.repository.db.QuietDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.musicplayersam.repository.db.dao.LocalMusicDao localMusicDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.musicplayersam.repository.db.dao.KeyValueDao keyValueDao();
    
    public QuietDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/musicplayersam/repository/db/QuietDatabase$Companion;", "", "()V", "DB_NAME", "", "instance", "Lcom/example/musicplayersam/repository/db/QuietDatabase;", "getInstance", "()Lcom/example/musicplayersam/repository/db/QuietDatabase;", "instance$delegate", "Lkotlin/Lazy;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.musicplayersam.repository.db.QuietDatabase getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
package com.example.musicplayersam.repository.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\'J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\'J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u000b\u001a\u00020\tH\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/musicplayersam/repository/db/dao/LocalMusicDao;", "", "()V", "getAllMusics", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/musicplayersam/repository/db/entity/LocalMusic;", "getMusicsByAlbum", "album", "", "getMusicsByArtist", "artist", "insertMusic", "", "music", "app_debug"})
public abstract class LocalMusicDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from local_music")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.musicplayersam.repository.db.entity.LocalMusic>> getAllMusics();
    
    @androidx.room.Insert()
    public abstract long insertMusic(@org.jetbrains.annotations.NotNull()
    com.example.musicplayersam.repository.db.entity.LocalMusic music);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from local_music where artistString = :artist")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.musicplayersam.repository.db.entity.LocalMusic>> getMusicsByArtist(@org.jetbrains.annotations.NotNull()
    java.lang.String artist);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from local_music where albumString = :album")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.musicplayersam.repository.db.entity.LocalMusic>> getMusicsByAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String album);
    
    public LocalMusicDao() {
        super();
    }
}
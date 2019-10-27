package com.example.musicplayersam.repository.db.entity;

import java.lang.System;

@androidx.room.Entity(tableName = "local_music", indices = {@androidx.room.Index(unique = true, value = {"fileUri"}), @androidx.room.Index(unique = false, value = {"albumString"}), @androidx.room.Index(unique = false, value = {"artistString"})})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c2\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0017J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/musicplayersam/repository/db/entity/LocalMusic;", "Lcom/example/musicplayersam/model/vo/Music;", "id", "", "fileUri", "", "title", "albumString", "artistString", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumString", "()Ljava/lang/String;", "getArtistString", "getFileUri", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getAlbum", "Lcom/example/musicplayersam/model/vo/Album;", "getArtists", "", "Lcom/example/musicplayersam/model/vo/Artist;", "getId", "getPlayUrl", "getTitle", "hashCode", "", "toString", "app_debug"})
public final class LocalMusic extends com.example.musicplayersam.model.vo.Music {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    
    /**
     * file path;
     * unique uri, start with file://
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fileUri = null;
    
    /**
     * song title
     */
    private final java.lang.String title = null;
    
    /**
     * song album
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String albumString = null;
    
    /**
     * artist
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String artistString = null;
    
    @java.lang.Override()
    public long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Ignore()
    @java.lang.Override()
    public com.example.musicplayersam.model.vo.Album getAlbum() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Ignore()
    @java.lang.Override()
    public java.util.List<com.example.musicplayersam.model.vo.Artist> getArtists() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Ignore()
    @java.lang.Override()
    public java.lang.String getPlayUrl() {
        return null;
    }
    
    /**
     * file path;
     * unique uri, start with file://
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileUri() {
        return null;
    }
    
    /**
     * song album
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAlbumString() {
        return null;
    }
    
    /**
     * artist
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getArtistString() {
        return null;
    }
    
    public LocalMusic(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String fileUri, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String albumString, @org.jetbrains.annotations.NotNull()
    java.lang.String artistString) {
        super();
    }
    
    private final long component1() {
        return 0L;
    }
    
    /**
     * file path;
     * unique uri, start with file://
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * song title
     */
    private final java.lang.String component3() {
        return null;
    }
    
    /**
     * song album
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * artist
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.musicplayersam.repository.db.entity.LocalMusic copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String fileUri, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String albumString, @org.jetbrains.annotations.NotNull()
    java.lang.String artistString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}
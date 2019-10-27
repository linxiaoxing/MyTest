package com.example.musicplayersam.model.vo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/example/musicplayersam/model/vo/Music;", "Ljava/io/Serializable;", "()V", "equals", "", "other", "", "getAlbum", "Lcom/example/musicplayersam/model/vo/Album;", "getArtists", "", "Lcom/example/musicplayersam/model/vo/Artist;", "getId", "", "getPlayUrl", "", "getTitle", "hashCode", "", "app_debug"})
public abstract class Music implements java.io.Serializable {
    
    public abstract long getId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTitle();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.musicplayersam.model.vo.Album getAlbum();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.musicplayersam.model.vo.Artist> getArtists();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getPlayUrl();
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    public Music() {
        super();
    }
}
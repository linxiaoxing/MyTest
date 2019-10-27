package com.example.musicplayersam.model.vo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/musicplayersam/model/vo/Album;", "Ljava/io/Serializable;", "()V", "getCoverImageUrl", "", "getId", "", "getName", "", "app_debug"})
public abstract class Album implements java.io.Serializable {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCoverImageUrl();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getName();
    
    public abstract long getId();
    
    public Album() {
        super();
    }
}
package com.example.musicplayersam.model.vo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/musicplayersam/model/vo/Artist;", "Ljava/io/Serializable;", "()V", "getId", "", "getName", "", "app_debug"})
public abstract class Artist implements java.io.Serializable {
    
    public abstract long getId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getName();
    
    public Artist() {
        super();
    }
}
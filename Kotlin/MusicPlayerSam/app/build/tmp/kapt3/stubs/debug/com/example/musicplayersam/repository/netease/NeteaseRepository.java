package com.example.musicplayersam.repository.netease;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/musicplayersam/repository/netease/NeteaseRepository;", "Landroidx/lifecycle/ViewModel;", "service", "Lcom/example/musicplayersam/repository/netease/CloudMusicService;", "(Lcom/example/musicplayersam/repository/netease/CloudMusicService;)V", "getLoginUser", "Lcom/example/musicplayersam/model/vo/User;", "Companion", "app_debug"})
public final class NeteaseRepository extends androidx.lifecycle.ViewModel {
    private final com.example.musicplayersam.repository.netease.CloudMusicService service = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.example.musicplayersam.repository.netease.NeteaseRepository instance = null;
    private static final java.lang.String KEY_USER = "netease_repository_user";
    private static final java.lang.String REMOTE_KEY_MESSAGE = "msg";
    public static final com.example.musicplayersam.repository.netease.NeteaseRepository.Companion Companion = null;
    
    /**
     * @return null when no user login
     */
    @org.jetbrains.annotations.Nullable()
    public final com.example.musicplayersam.model.vo.User getLoginUser() {
        return null;
    }
    
    public NeteaseRepository(@org.jetbrains.annotations.NotNull()
    com.example.musicplayersam.repository.netease.CloudMusicService service) {
        super();
    }
    
    public NeteaseRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/musicplayersam/repository/netease/NeteaseRepository$Companion;", "", "()V", "KEY_USER", "", "REMOTE_KEY_MESSAGE", "instance", "Lcom/example/musicplayersam/repository/netease/NeteaseRepository;", "getInstance", "()Lcom/example/musicplayersam/repository/netease/NeteaseRepository;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.musicplayersam.repository.netease.NeteaseRepository getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
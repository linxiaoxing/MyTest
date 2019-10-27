package com.example.musicplayersam.utils.component.support;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/example/musicplayersam/utils/component/support/QuietViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "()V", "database", "Lcom/example/musicplayersam/repository/db/QuietDatabase;", "getDatabase", "()Lcom/example/musicplayersam/repository/db/QuietDatabase;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "createViewModel", "app_debug"})
public class QuietViewModelProvider extends androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory {
    
    @org.jetbrains.annotations.NotNull()
    protected final com.example.musicplayersam.repository.db.QuietDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public final <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    /**
     * create view model by [modelClass]
     */
    @org.jetbrains.annotations.NotNull()
    public androidx.lifecycle.ViewModel createViewModel(@org.jetbrains.annotations.NotNull()
    java.lang.Class<androidx.lifecycle.ViewModel> modelClass) {
        return null;
    }
    
    public QuietViewModelProvider() {
        super(null);
    }
}
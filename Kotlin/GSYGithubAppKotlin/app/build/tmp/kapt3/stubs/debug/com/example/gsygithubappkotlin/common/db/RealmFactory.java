package com.example.gsygithubappkotlin.common.db;

import java.lang.System;

/**
 * Realm数据初始化
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/gsygithubappkotlin/common/db/RealmFactory;", "", "()V", "Companion", "app_debug"})
public final class RealmFactory {
    private static final long VERSION = 1L;
    private static volatile com.example.gsygithubappkotlin.common.db.RealmFactory mRealmFactory;
    public static final com.example.gsygithubappkotlin.common.db.RealmFactory.Companion Companion = null;
    
    private RealmFactory() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/gsygithubappkotlin/common/db/RealmFactory$Companion;", "", "()V", "VERSION", "", "instance", "Lcom/example/gsygithubappkotlin/common/db/RealmFactory;", "getInstance", "()Lcom/example/gsygithubappkotlin/common/db/RealmFactory;", "mRealmFactory", "getRealmObservable", "Lio/reactivex/Observable;", "Lio/realm/Realm;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gsygithubappkotlin.common.db.RealmFactory getInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final io.reactivex.Observable<io.realm.Realm> getRealmObservable() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
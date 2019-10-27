package com.example.gsykotlin.common.config;

import java.lang.System;

/**
 * App 配置
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/gsykotlin/common/config/AppConfig;", "", "()V", "ACCESS_TOKEN", "", "CACHE_MAX_AGE", "", "GITHUB_API_BASE_URL", "GITHUB_BASE_URL", "GITHUB_CONTENT_BASE_URL", "GRAPHIC_HOST", "HTTP_MAX_CACHE_SIZE", "HTTP_TIME_OUT", "IMAGE_MAX_CACHE_SIZE", "PAGE_SIZE", "", "PASSWORD", "USER_BASIC_CODE", "USER_INFO", "USER_NAME", "app_debug"})
public final class AppConfig {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GITHUB_BASE_URL = "https://github.com/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GITHUB_API_BASE_URL = "https://api.github.com/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GITHUB_CONTENT_BASE_URL = "https://raw.githubusercontent.com/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GRAPHIC_HOST = "https://ghchart.rshah.org/";
    public static final int PAGE_SIZE = 30;
    public static final long HTTP_TIME_OUT = 20000L;
    public static final long HTTP_MAX_CACHE_SIZE = 16777216L;
    public static final long IMAGE_MAX_CACHE_SIZE = 16777216L;
    public static final long CACHE_MAX_AGE = 604800L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACCESS_TOKEN = "accessToken";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_BASIC_CODE = "userBasicCode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PASSWORD = "password";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_INFO = "userInfo";
    public static final com.example.gsykotlin.common.config.AppConfig INSTANCE = null;
    
    private AppConfig() {
        super();
    }
}
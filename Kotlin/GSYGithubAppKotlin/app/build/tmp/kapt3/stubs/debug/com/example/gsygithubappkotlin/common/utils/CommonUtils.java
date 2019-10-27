package com.example.gsygithubappkotlin.common.utils;

import java.lang.System;

/**
 * 通用工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/gsygithubappkotlin/common/utils/CommonUtils;", "", "()V", "DAYS_LIMIT", "", "HOURS_LIMIT", "MILLIS_LIMIT", "MINUTES_LIMIT", "SECONDS_LIMIT", "loadUserHeaderImage", "", "imageView", "Landroid/widget/ImageView;", "url", "", "size", "Landroid/graphics/Point;", "app_debug"})
public final class CommonUtils {
    private static final double MILLIS_LIMIT = 1000.0;
    private static final double SECONDS_LIMIT = 60000.0;
    private static final double MINUTES_LIMIT = 3600000.0;
    private static final double HOURS_LIMIT = 8.64E7;
    private static final double DAYS_LIMIT = 2.592E9;
    public static final com.example.gsygithubappkotlin.common.utils.CommonUtils INSTANCE = null;
    
    /**
     * 加载用户头像
     */
    public final void loadUserHeaderImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.graphics.Point size) {
    }
    
    private CommonUtils() {
        super();
    }
}
package com.example.bilibilikotlin.adapter.home.live;

import java.lang.System;

/**
 * 描述:直播界面的Adapter
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/example/bilibilikotlin/adapter/home/live/LiveAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/example/bilibilikotlin/bean/live/MulLive;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "mulLive", "initEntrance", "Lcom/example/bilibilikotlin/bean/live/support/LiveEnter;", "app_debug"})
public final class LiveAdapter extends com.chad.library.adapter.base.BaseMultiItemQuickAdapter<com.example.bilibilikotlin.bean.live.MulLive, com.chad.library.adapter.base.BaseViewHolder> {
    
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.chad.library.adapter.base.BaseViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.live.MulLive mulLive) {
    }
    
    /**
     * 初始化入口
     */
    private final java.util.List<com.example.bilibilikotlin.bean.live.support.LiveEnter> initEntrance() {
        return null;
    }
    
    public LiveAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.live.MulLive> data) {
        super(null);
    }
}
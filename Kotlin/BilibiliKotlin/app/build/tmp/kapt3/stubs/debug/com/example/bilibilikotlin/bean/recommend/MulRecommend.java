package com.example.bilibilikotlin.bean.recommend;

import java.lang.System;

/**
 * * 描述:推荐多布局
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0003H\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/MulRecommend;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemTypez", "", "spanSize", "recommend", "Lcom/example/bilibilikotlin/bean/recommend/Recommend;", "data", "", "Lcom/example/bilibilikotlin/bean/recommend/Recommend$BannerItem;", "(IILcom/example/bilibilikotlin/bean/recommend/Recommend;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getItemTypez", "()I", "getRecommend", "()Lcom/example/bilibilikotlin/bean/recommend/Recommend;", "setRecommend", "(Lcom/example/bilibilikotlin/bean/recommend/Recommend;)V", "getSpanSize", "setSpanSize", "(I)V", "getItemType", "Companion", "app_debug"})
public final class MulRecommend implements com.chad.library.adapter.base.entity.MultiItemEntity {
    private final int itemTypez = 0;
    private int spanSize;
    @org.jetbrains.annotations.Nullable()
    private com.example.bilibilikotlin.bean.recommend.Recommend recommend;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> data;
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private static final int HEADER_SPAN_SIZE = 2;
    private static final int ITEM_SPAN_SIZE = 1;
    public static final com.example.bilibilikotlin.bean.recommend.MulRecommend.Companion Companion = null;
    
    @java.lang.Override()
    public int getItemType() {
        return 0;
    }
    
    public final int getItemTypez() {
        return 0;
    }
    
    public final int getSpanSize() {
        return 0;
    }
    
    public final void setSpanSize(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bilibilikotlin.bean.recommend.Recommend getRecommend() {
        return null;
    }
    
    public final void setRecommend(@org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.recommend.Recommend p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> p0) {
    }
    
    public MulRecommend(int itemTypez, int spanSize, @org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.recommend.Recommend recommend, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> data) {
        super();
    }
    
    public MulRecommend() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/MulRecommend$Companion;", "", "()V", "HEADER_SPAN_SIZE", "", "getHEADER_SPAN_SIZE", "()I", "ITEM_SPAN_SIZE", "getITEM_SPAN_SIZE", "TYPE_HEADER", "getTYPE_HEADER", "TYPE_ITEM", "getTYPE_ITEM", "app_debug"})
    public static final class Companion {
        
        public final int getTYPE_HEADER() {
            return 0;
        }
        
        public final int getTYPE_ITEM() {
            return 0;
        }
        
        public final int getHEADER_SPAN_SIZE() {
            return 0;
        }
        
        public final int getITEM_SPAN_SIZE() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}
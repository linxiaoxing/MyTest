package com.example.bilibilikotlin.bean.app.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/example/bilibilikotlin/bean/app/video/MulComment;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemTypez", "", "hotsBean", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$HotsBean;", "repliesBean", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$RepliesBean;", "(ILcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$HotsBean;Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$RepliesBean;)V", "getHotsBean", "()Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$HotsBean;", "setHotsBean", "(Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$HotsBean;)V", "getItemTypez", "()I", "setItemTypez", "(I)V", "getRepliesBean", "()Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$RepliesBean;", "setRepliesBean", "(Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean$RepliesBean;)V", "getItemType", "Companion", "app_debug"})
public final class MulComment implements com.chad.library.adapter.base.entity.MultiItemEntity {
    private int itemTypez;
    @org.jetbrains.annotations.Nullable()
    private com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.HotsBean hotsBean;
    @org.jetbrains.annotations.Nullable()
    private com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.RepliesBean repliesBean;
    private static final int TYPE_COMMENT_HOT_ITEM = 2;
    private static final int TYPE_COMMENT_MORE = 3;
    private static final int TYPE_COMMENT_NOMAL_ITEM = 4;
    public static final com.example.bilibilikotlin.bean.app.video.MulComment.Companion Companion = null;
    
    @java.lang.Override()
    public int getItemType() {
        return 0;
    }
    
    public final int getItemTypez() {
        return 0;
    }
    
    public final void setItemTypez(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.HotsBean getHotsBean() {
        return null;
    }
    
    public final void setHotsBean(@org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.HotsBean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.RepliesBean getRepliesBean() {
        return null;
    }
    
    public final void setRepliesBean(@org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.RepliesBean p0) {
    }
    
    public MulComment(int itemTypez, @org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.HotsBean hotsBean, @org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean.RepliesBean repliesBean) {
        super();
    }
    
    public MulComment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/bilibilikotlin/bean/app/video/MulComment$Companion;", "", "()V", "TYPE_COMMENT_HOT_ITEM", "", "getTYPE_COMMENT_HOT_ITEM", "()I", "TYPE_COMMENT_MORE", "getTYPE_COMMENT_MORE", "TYPE_COMMENT_NOMAL_ITEM", "getTYPE_COMMENT_NOMAL_ITEM", "app_debug"})
    public static final class Companion {
        
        public final int getTYPE_COMMENT_HOT_ITEM() {
            return 0;
        }
        
        public final int getTYPE_COMMENT_MORE() {
            return 0;
        }
        
        public final int getTYPE_COMMENT_NOMAL_ITEM() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}
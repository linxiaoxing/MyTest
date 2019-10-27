package com.example.bilibilikotlin.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/example/bilibilikotlin/event/Event;", "", "()V", "RegionEntrancePositionEvent", "StartNavigationEvent", "VideoDetailCommentEvent", "VideoDetailEvent", "app_debug"})
public final class Event {
    public static final com.example.bilibilikotlin.event.Event INSTANCE = null;
    
    private Event() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/event/Event$RegionEntrancePositionEvent;", "", "()V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "app_debug"})
    public static final class RegionEntrancePositionEvent {
        private int position;
        
        public final int getPosition() {
            return 0;
        }
        
        public final void setPosition(int p0) {
        }
        
        public RegionEntrancePositionEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/event/Event$StartNavigationEvent;", "", "()V", "start", "", "getStart", "()Z", "setStart", "(Z)V", "app_debug"})
    public static final class StartNavigationEvent {
        private boolean start;
        
        public final boolean getStart() {
            return false;
        }
        
        public final void setStart(boolean p0) {
        }
        
        public StartNavigationEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/event/Event$VideoDetailEvent;", "", "()V", "videoDetail", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetail$DataBean;", "getVideoDetail", "()Lcom/example/bilibilikotlin/bean/app/video/VideoDetail$DataBean;", "setVideoDetail", "(Lcom/example/bilibilikotlin/bean/app/video/VideoDetail$DataBean;)V", "app_debug"})
    public static final class VideoDetailEvent {
        @org.jetbrains.annotations.Nullable()
        private com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean videoDetail;
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean getVideoDetail() {
            return null;
        }
        
        public final void setVideoDetail(@org.jetbrains.annotations.Nullable()
        com.example.bilibilikotlin.bean.app.video.VideoDetail.DataBean p0) {
        }
        
        public VideoDetailEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/event/Event$VideoDetailCommentEvent;", "", "()V", "videoDetailComment", "Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean;", "getVideoDetailComment", "()Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean;", "setVideoDetailComment", "(Lcom/example/bilibilikotlin/bean/app/video/VideoDetailComment$DataBean;)V", "app_debug"})
    public static final class VideoDetailCommentEvent {
        @org.jetbrains.annotations.Nullable()
        private com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean videoDetailComment;
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean getVideoDetailComment() {
            return null;
        }
        
        public final void setVideoDetailComment(@org.jetbrains.annotations.Nullable()
        com.example.bilibilikotlin.bean.app.video.VideoDetailComment.DataBean p0) {
        }
        
        public VideoDetailCommentEvent() {
            super();
        }
    }
}
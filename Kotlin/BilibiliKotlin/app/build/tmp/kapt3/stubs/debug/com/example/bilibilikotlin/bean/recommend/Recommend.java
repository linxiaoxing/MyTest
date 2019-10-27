package com.example.bilibilikotlin.bean.recommend;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B\u00e9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001f\u00a2\u0006\u0002\u0010#J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010g\u001a\u00020\u0006H\u00c6\u0003J\t\u0010h\u001a\u00020\u0003H\u00c6\u0003J\t\u0010i\u001a\u00020\u0014H\u00c6\u0003J\t\u0010j\u001a\u00020\u0006H\u00c6\u0003J\t\u0010k\u001a\u00020\u0006H\u00c6\u0003J\t\u0010l\u001a\u00020\u0006H\u00c6\u0003J\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\t\u0010p\u001a\u00020\u0006H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\u0006H\u00c6\u0003J\t\u0010s\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010t\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u00c6\u0003J\u000f\u0010u\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u00c6\u0003J\t\u0010v\u001a\u00020\u0006H\u00c6\u0003J\t\u0010w\u001a\u00020\u0003H\u00c6\u0003J\t\u0010x\u001a\u00020\u0003H\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\u0006H\u00c6\u0003J\t\u0010|\u001a\u00020\u0006H\u00c6\u0003J\u00a3\u0002\u0010}\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u00c6\u0001J\u0014\u0010~\u001a\u00020\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0006H\u00d6\u0001J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010\'R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010\'R \u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010\'R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010\'R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010%\"\u0004\bI\u0010\'R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010%\"\u0004\bO\u0010\'R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010)\"\u0004\bQ\u0010+R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010)\"\u0004\bS\u0010+R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010)\"\u0004\bU\u0010+R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010)\"\u0004\b[\u0010+R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010%\"\u0004\b]\u0010\'R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010%\"\u0004\b_\u0010\'R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010\'\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/Recommend;", "", "param", "", "goto", "idx", "", "title", "cover", "uri", "desc", "play", "danmaku", "reply", "favorite", "coin", "share", "tid", "tname", "tag", "Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag;", "ctime", "duration", "mid", "name", "face", "online", "area", "area_id", "open", "banner_item", "", "Lcom/example/bilibilikotlin/bean/recommend/Recommend$BannerItem;", "dislike_reasons", "Lcom/example/bilibilikotlin/bean/recommend/Recommend$DislikeReasons;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIILjava/lang/String;Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/util/List;Ljava/util/List;)V", "getArea", "()Ljava/lang/String;", "setArea", "(Ljava/lang/String;)V", "getArea_id", "()I", "setArea_id", "(I)V", "getBanner_item", "()Ljava/util/List;", "setBanner_item", "(Ljava/util/List;)V", "getCoin", "setCoin", "getCover", "setCover", "getCtime", "setCtime", "getDanmaku", "setDanmaku", "getDesc", "setDesc", "getDislike_reasons", "setDislike_reasons", "getDuration", "setDuration", "getFace", "setFace", "getFavorite", "setFavorite", "getGoto", "setGoto", "getIdx", "setIdx", "getMid", "setMid", "getName", "setName", "getOnline", "setOnline", "getOpen", "setOpen", "getParam", "setParam", "getPlay", "setPlay", "getReply", "setReply", "getShare", "setShare", "getTag", "()Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag;", "setTag", "(Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag;)V", "getTid", "setTid", "getTitle", "setTitle", "getTname", "setTname", "getUri", "setUri", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "BannerItem", "DislikeReasons", "Tag", "app_debug"})
public final class Recommend {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String param;
    private int idx;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cover;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uri;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String desc;
    private int play;
    private int danmaku;
    private int reply;
    private int favorite;
    private int coin;
    private int share;
    private int tid;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tname;
    @org.jetbrains.annotations.NotNull()
    private com.example.bilibilikotlin.bean.recommend.Recommend.Tag tag;
    private int ctime;
    private int duration;
    private int mid;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String face;
    private int online;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String area;
    private int area_id;
    private int open;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> banner_item;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> dislike_reasons;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParam() {
        return null;
    }
    
    public final void setParam(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGoto() {
        return null;
    }
    
    public final void setGoto(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getIdx() {
        return 0;
    }
    
    public final void setIdx(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCover() {
        return null;
    }
    
    public final void setCover(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    public final void setDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPlay() {
        return 0;
    }
    
    public final void setPlay(int p0) {
    }
    
    public final int getDanmaku() {
        return 0;
    }
    
    public final void setDanmaku(int p0) {
    }
    
    public final int getReply() {
        return 0;
    }
    
    public final void setReply(int p0) {
    }
    
    public final int getFavorite() {
        return 0;
    }
    
    public final void setFavorite(int p0) {
    }
    
    public final int getCoin() {
        return 0;
    }
    
    public final void setCoin(int p0) {
    }
    
    public final int getShare() {
        return 0;
    }
    
    public final void setShare(int p0) {
    }
    
    public final int getTid() {
        return 0;
    }
    
    public final void setTid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTname() {
        return null;
    }
    
    public final void setTname(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag getTag() {
        return null;
    }
    
    public final void setTag(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.recommend.Recommend.Tag p0) {
    }
    
    public final int getCtime() {
        return 0;
    }
    
    public final void setCtime(int p0) {
    }
    
    public final int getDuration() {
        return 0;
    }
    
    public final void setDuration(int p0) {
    }
    
    public final int getMid() {
        return 0;
    }
    
    public final void setMid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFace() {
        return null;
    }
    
    public final void setFace(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getOnline() {
        return 0;
    }
    
    public final void setOnline(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getArea() {
        return null;
    }
    
    public final void setArea(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getArea_id() {
        return 0;
    }
    
    public final void setArea_id(int p0) {
    }
    
    public final int getOpen() {
        return 0;
    }
    
    public final void setOpen(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> getBanner_item() {
        return null;
    }
    
    public final void setBanner_item(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> getDislike_reasons() {
        return null;
    }
    
    public final void setDislike_reasons(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> p0) {
    }
    
    public Recommend(@org.jetbrains.annotations.NotNull()
    java.lang.String param, @org.jetbrains.annotations.NotNull()
    java.lang.String p1_1589425, int idx, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String cover, @org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, int play, int danmaku, int reply, int favorite, int coin, int share, int tid, @org.jetbrains.annotations.NotNull()
    java.lang.String tname, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.recommend.Recommend.Tag tag, int ctime, int duration, int mid, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String face, int online, @org.jetbrains.annotations.NotNull()
    java.lang.String area, int area_id, int open, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> banner_item, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> dislike_reasons) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int component14() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    public final int component22() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    public final int component24() {
        return 0;
    }
    
    public final int component25() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.bean.recommend.Recommend copy(@org.jetbrains.annotations.NotNull()
    java.lang.String param, @org.jetbrains.annotations.NotNull()
    java.lang.String p1_1589425, int idx, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String cover, @org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, int play, int danmaku, int reply, int favorite, int coin, int share, int tid, @org.jetbrains.annotations.NotNull()
    java.lang.String tname, @org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.bean.recommend.Recommend.Tag tag, int ctime, int duration, int mid, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String face, int online, @org.jetbrains.annotations.NotNull()
    java.lang.String area, int area_id, int open, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem> banner_item, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons> dislike_reasons) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag;", "", "tag_id", "", "tag_name", "", "count", "Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag$Count;", "(ILjava/lang/String;Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag$Count;)V", "getCount", "()Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag$Count;", "setCount", "(Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag$Count;)V", "getTag_id", "()I", "setTag_id", "(I)V", "getTag_name", "()Ljava/lang/String;", "setTag_name", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Count", "app_debug"})
    public static final class Tag {
        private int tag_id;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String tag_name;
        @org.jetbrains.annotations.NotNull()
        private com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count count;
        
        public final int getTag_id() {
            return 0;
        }
        
        public final void setTag_id(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTag_name() {
            return null;
        }
        
        public final void setTag_name(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count getCount() {
            return null;
        }
        
        public final void setCount(@org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count p0) {
        }
        
        public Tag(int tag_id, @org.jetbrains.annotations.NotNull()
        java.lang.String tag_name, @org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count count) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag copy(int tag_id, @org.jetbrains.annotations.NotNull()
        java.lang.String tag_name, @org.jetbrains.annotations.NotNull()
        com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count count) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
        
        @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/Recommend$Tag$Count;", "", "atten", "", "(I)V", "getAtten", "()I", "setAtten", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
        public static final class Count {
            private int atten;
            
            public final int getAtten() {
                return 0;
            }
            
            public final void setAtten(int p0) {
            }
            
            public Count(int atten) {
                super();
            }
            
            public final int component1() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.bilibilikotlin.bean.recommend.Recommend.Tag.Count copy(int atten) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0016J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0011H\u00c6\u0003J\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\t\u0010C\u001a\u00020\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\u0011H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0005H\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\u00b3\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010O\u001a\u00020\u00112\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001J\t\u0010R\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010-\"\u0004\b0\u0010/R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001a\u00a8\u0006S"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/Recommend$BannerItem;", "", "id", "", "title", "", "image", "hash", "uri", "request_id", "server_type", "resource_id", "index", "cm_mark", "creative_id", "src_id", "is_ad_loc", "", "ad_cb", "client_ip", "is_ad", "click_url", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAd_cb", "()Ljava/lang/String;", "setAd_cb", "(Ljava/lang/String;)V", "getClick_url", "setClick_url", "getClient_ip", "setClient_ip", "getCm_mark", "()I", "setCm_mark", "(I)V", "getCreative_id", "setCreative_id", "getHash", "setHash", "getId", "setId", "getImage", "setImage", "getIndex", "setIndex", "()Z", "set_ad", "(Z)V", "set_ad_loc", "getRequest_id", "setRequest_id", "getResource_id", "setResource_id", "getServer_type", "setServer_type", "getSrc_id", "setSrc_id", "getTitle", "setTitle", "getUri", "setUri", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class BannerItem {
        private int id;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String title;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String image;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String hash;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String uri;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String request_id;
        private int server_type;
        private int resource_id;
        private int index;
        private int cm_mark;
        private int creative_id;
        private int src_id;
        private boolean is_ad_loc;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String ad_cb;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String client_ip;
        private boolean is_ad;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String click_url;
        
        public final int getId() {
            return 0;
        }
        
        public final void setId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getImage() {
            return null;
        }
        
        public final void setImage(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getHash() {
            return null;
        }
        
        public final void setHash(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUri() {
            return null;
        }
        
        public final void setUri(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRequest_id() {
            return null;
        }
        
        public final void setRequest_id(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getServer_type() {
            return 0;
        }
        
        public final void setServer_type(int p0) {
        }
        
        public final int getResource_id() {
            return 0;
        }
        
        public final void setResource_id(int p0) {
        }
        
        public final int getIndex() {
            return 0;
        }
        
        public final void setIndex(int p0) {
        }
        
        public final int getCm_mark() {
            return 0;
        }
        
        public final void setCm_mark(int p0) {
        }
        
        public final int getCreative_id() {
            return 0;
        }
        
        public final void setCreative_id(int p0) {
        }
        
        public final int getSrc_id() {
            return 0;
        }
        
        public final void setSrc_id(int p0) {
        }
        
        public final boolean is_ad_loc() {
            return false;
        }
        
        public final void set_ad_loc(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAd_cb() {
            return null;
        }
        
        public final void setAd_cb(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getClient_ip() {
            return null;
        }
        
        public final void setClient_ip(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean is_ad() {
            return false;
        }
        
        public final void set_ad(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getClick_url() {
            return null;
        }
        
        public final void setClick_url(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public BannerItem(int id, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String image, @org.jetbrains.annotations.NotNull()
        java.lang.String hash, @org.jetbrains.annotations.NotNull()
        java.lang.String uri, @org.jetbrains.annotations.NotNull()
        java.lang.String request_id, int server_type, int resource_id, int index, int cm_mark, int creative_id, int src_id, boolean is_ad_loc, @org.jetbrains.annotations.NotNull()
        java.lang.String ad_cb, @org.jetbrains.annotations.NotNull()
        java.lang.String client_ip, boolean is_ad, @org.jetbrains.annotations.NotNull()
        java.lang.String click_url) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        public final int component7() {
            return 0;
        }
        
        public final int component8() {
            return 0;
        }
        
        public final int component9() {
            return 0;
        }
        
        public final int component10() {
            return 0;
        }
        
        public final int component11() {
            return 0;
        }
        
        public final int component12() {
            return 0;
        }
        
        public final boolean component13() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component15() {
            return null;
        }
        
        public final boolean component16() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component17() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.recommend.Recommend.BannerItem copy(int id, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String image, @org.jetbrains.annotations.NotNull()
        java.lang.String hash, @org.jetbrains.annotations.NotNull()
        java.lang.String uri, @org.jetbrains.annotations.NotNull()
        java.lang.String request_id, int server_type, int resource_id, int index, int cm_mark, int creative_id, int src_id, boolean is_ad_loc, @org.jetbrains.annotations.NotNull()
        java.lang.String ad_cb, @org.jetbrains.annotations.NotNull()
        java.lang.String client_ip, boolean is_ad, @org.jetbrains.annotations.NotNull()
        java.lang.String click_url) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/example/bilibilikotlin/bean/recommend/Recommend$DislikeReasons;", "", "reason_id", "", "reason_name", "", "(ILjava/lang/String;)V", "getReason_id", "()I", "setReason_id", "(I)V", "getReason_name", "()Ljava/lang/String;", "setReason_name", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DislikeReasons {
        private int reason_id;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String reason_name;
        
        public final int getReason_id() {
            return 0;
        }
        
        public final void setReason_id(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getReason_name() {
            return null;
        }
        
        public final void setReason_name(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public DislikeReasons(int reason_id, @org.jetbrains.annotations.NotNull()
        java.lang.String reason_name) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.recommend.Recommend.DislikeReasons copy(int reason_id, @org.jetbrains.annotations.NotNull()
        java.lang.String reason_name) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}
package com.example.bilibilikotlin.bean.app.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u00017BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0003Jo\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\u0007H\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00068"}, d2 = {"Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer;", "", "from", "", "result", "format", "timelength", "", "accept_format", "seek_param", "seek_type", "accept_quality", "", "durl", "Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer$DurlBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAccept_format", "()Ljava/lang/String;", "setAccept_format", "(Ljava/lang/String;)V", "getAccept_quality", "()Ljava/util/List;", "setAccept_quality", "(Ljava/util/List;)V", "getDurl", "setDurl", "getFormat", "setFormat", "getFrom", "setFrom", "getResult", "setResult", "getSeek_param", "setSeek_param", "getSeek_type", "setSeek_type", "getTimelength", "()I", "setTimelength", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "DurlBean", "app_debug"})
public final class VideoPlayer {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String from;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String result;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String format;
    private int timelength;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String accept_format;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String seek_param;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String seek_type;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> accept_quality;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> durl;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFrom() {
        return null;
    }
    
    public final void setFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormat() {
        return null;
    }
    
    public final void setFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getTimelength() {
        return 0;
    }
    
    public final void setTimelength(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccept_format() {
        return null;
    }
    
    public final void setAccept_format(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeek_param() {
        return null;
    }
    
    public final void setSeek_param(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeek_type() {
        return null;
    }
    
    public final void setSeek_type(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getAccept_quality() {
        return null;
    }
    
    public final void setAccept_quality(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> getDurl() {
        return null;
    }
    
    public final void setDurl(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> p0) {
    }
    
    public VideoPlayer(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String result, @org.jetbrains.annotations.NotNull()
    java.lang.String format, int timelength, @org.jetbrains.annotations.NotNull()
    java.lang.String accept_format, @org.jetbrains.annotations.NotNull()
    java.lang.String seek_param, @org.jetbrains.annotations.NotNull()
    java.lang.String seek_type, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> accept_quality, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> durl) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bilibilikotlin.bean.app.video.VideoPlayer copy(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String result, @org.jetbrains.annotations.NotNull()
    java.lang.String format, int timelength, @org.jetbrains.annotations.NotNull()
    java.lang.String accept_format, @org.jetbrains.annotations.NotNull()
    java.lang.String seek_param, @org.jetbrains.annotations.NotNull()
    java.lang.String seek_type, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> accept_quality, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean> durl) {
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
    
    /**
     * from : local
     * result : suee
     * format : mp4
     * timelength : 2401795
     * accept_format : flv,hdmp4,mp4
     * accept_quality : [80,48,16]
     * seek_param : start
     * seek_type : second
     * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u00c6\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/example/bilibilikotlin/bean/app/video/VideoPlayer$DurlBean;", "", "order", "", "length", "size", "url", "", "backup_url", "", "(IIILjava/lang/String;Ljava/util/List;)V", "getBackup_url", "()Ljava/util/List;", "setBackup_url", "(Ljava/util/List;)V", "getLength", "()I", "setLength", "(I)V", "getOrder", "setOrder", "getSize", "setSize", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DurlBean {
        private int order;
        private int length;
        private int size;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String url;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<java.lang.String> backup_url;
        
        public final int getOrder() {
            return 0;
        }
        
        public final void setOrder(int p0) {
        }
        
        public final int getLength() {
            return 0;
        }
        
        public final void setLength(int p0) {
        }
        
        public final int getSize() {
            return 0;
        }
        
        public final void setSize(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        public final void setUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getBackup_url() {
            return null;
        }
        
        public final void setBackup_url(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> p0) {
        }
        
        public DurlBean(int order, int length, int size, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> backup_url) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component5() {
            return null;
        }
        
        /**
         * from : local
         * result : suee
         * format : mp4
         * timelength : 2401795
         * accept_format : flv,hdmp4,mp4
         * accept_quality : [80,48,16]
         * seek_param : start
         * seek_type : second
         * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.bilibilikotlin.bean.app.video.VideoPlayer.DurlBean copy(int order, int length, int size, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> backup_url) {
            return null;
        }
        
        /**
         * from : local
         * result : suee
         * format : mp4
         * timelength : 2401795
         * accept_format : flv,hdmp4,mp4
         * accept_quality : [80,48,16]
         * seek_param : start
         * seek_type : second
         * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * from : local
         * result : suee
         * format : mp4
         * timelength : 2401795
         * accept_format : flv,hdmp4,mp4
         * accept_quality : [80,48,16]
         * seek_param : start
         * seek_type : second
         * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * from : local
         * result : suee
         * format : mp4
         * timelength : 2401795
         * accept_format : flv,hdmp4,mp4
         * accept_quality : [80,48,16]
         * seek_param : start
         * seek_type : second
         * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}
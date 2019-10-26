package com.example.bilibilikotlin.bean.app.video

data class VideoPlayer(var from: String,
                       var result: String,
                       var format: String,
                       var timelength: Int,
                       var accept_format: String,
                       var seek_param: String,
                       var seek_type: String,
                       var accept_quality: List<Int>,
                       var durl: List<DurlBean>
) {

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


    data class DurlBean(var order: Int,
                        var length: Int,
                        var size: Int,
                        var url: String,
                        var backup_url: List<String>) {
        /**
         * order : 1
         * length : 2401795
         * size : 145182349
         * url : http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006
         * backup_url : ["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]
         */


    }
}
package com.example.bilibilikotlin.bean.live

data class LiveEntrance(var entrance_icon: EntranceIconBean,
                        var id: Int,
                        var name: String) {

    /**
     * entrance_icon : {"height":120,"src":"http://static.hdslb.com/live-static/live-app/areaicon/android/xxhdpi/12.png?20170525111300","width":120}
     * id : 12
     * name : 手游直播
     */


    data class EntranceIconBean(var height: Int,
                                var src: String,
                                var width: Int) {
        /**
         * height : 120
         * src : http://static.hdslb.com/live-static/live-app/areaicon/android/xxhdpi/12.png?20170525111300
         * width : 120
         */

    }
}
package com.example.bilibilikotlin.bean.discover

/**
 * * 描述:活动中心
 */
data class ActivityCenter(var code: Int,
                          var total: Int,
                          var pages: Int,
                          var list: List<ListBean>) {

    data class ListBean(var cover: String,
                        var link: String,
                        var title: String,
                        var state: Int) {

        /**
         * cover : http://i0.hdslb.com/bfs/activity-plat/cover/20170605/r9vj2n3964.jpg
         * link : http://www.bilibili.com/blackboard/topic/activity-H12uuAGzZ.html
         * title : 加油！奋斗的六月
         * state : 0
         */


    }

}
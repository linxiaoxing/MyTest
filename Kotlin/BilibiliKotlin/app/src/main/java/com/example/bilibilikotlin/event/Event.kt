package com.example.bilibilikotlin.event

import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment

object Event {

    class RegionEntrancePositionEvent {
        var position: Int = -1
    }

    class StartNavigationEvent {
        var start: Boolean = false
    }

    class VideoDetailEvent {
        var videoDetail: VideoDetail.DataBean? = null
    }

    class VideoDetailCommentEvent {
        var videoDetailComment: VideoDetailComment.DataBean? = null
    }
}
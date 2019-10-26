package com.example.bilibilikotlin.mvp.contract.app.video

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.app.video.VideoPlayer
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser

interface VideoPlayerContract {
    interface View : BaseContract.BaseView {

        fun showVideoPlayer(videoPlayer: VideoPlayer)

        fun showAnimLoading()

        fun showDanmaku(baseDanmakuParser: BaseDanmakuParser)
    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {
        fun getVideoPlayerData()

    }
}
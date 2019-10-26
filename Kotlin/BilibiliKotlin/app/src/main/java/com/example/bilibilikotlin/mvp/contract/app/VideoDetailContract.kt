package com.example.bilibilikotlin.mvp.contract.app

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment

interface VideoDetailContract {
    interface View : BaseContract.BaseView {
        fun showVideoDetail(videoDetail: VideoDetail.DataBean)

        fun showVideoDetailComment(videoDetailComment: VideoDetailComment.DataBean)
    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {
        fun getVideoDetailData()

    }
}
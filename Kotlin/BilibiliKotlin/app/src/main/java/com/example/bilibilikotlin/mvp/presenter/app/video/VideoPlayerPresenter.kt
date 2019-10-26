package com.example.bilibilikotlin.mvp.presenter.app.video

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.media.danmuku.BiliDanmukuDownloadUtil
import com.example.bilibilikotlin.mvp.contract.app.video.VideoPlayerContract
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.utils.AppUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser
import javax.inject.Inject

class VideoPlayerPresenter @Inject constructor(private val retrofitHelper: RetrofitHelper) : RxPresenter<VideoPlayerContract.View>(), VideoPlayerContract.Presenter<VideoPlayerContract.View> {

    override fun getVideoPlayerData() {
        addSubscribe(retrofitHelper.getVideoPlayer()
            .doOnSubscribe({ mView?.showAnimLoading() })
            .flatMap({ videoPlayer ->
                AppUtils.runOnUI { mView?.showVideoPlayer(videoPlayer) }
                val url = "http://comment.bilibili.com/2143345.xml"
                BiliDanmukuDownloadUtil.downloadXML(url)//下载弹幕
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : BaseSubscriber<BaseDanmakuParser>(mView) {
                override fun onSuccess(baseDanmakuParser: BaseDanmakuParser) {
                    mView?.showDanmaku(baseDanmakuParser)
                }

                override fun onFailure(code: Int, message: String) {
                    mView?.showError(message)
                }
            }))
    }
}
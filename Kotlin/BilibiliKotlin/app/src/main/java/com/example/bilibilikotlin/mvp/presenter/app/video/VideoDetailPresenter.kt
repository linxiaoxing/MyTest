package com.example.bilibilikotlin.mvp.presenter.app.video

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment
import com.example.bilibilikotlin.bean.recommend.Recommend
import com.example.bilibilikotlin.mvp.contract.app.VideoDetailContract
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import com.example.bilibilikotlin.utils.JsonUtils
import com.google.gson.Gson
import com.google.gson.JsonParser
import io.reactivex.Flowable
import javax.inject.Inject

class VideoDetailPresenter @Inject constructor(private val retrofitHelper: RetrofitHelper) : RxPresenter<VideoDetailContract.View>(), VideoDetailContract.Presenter<VideoDetailContract.View> {

    override fun getVideoDetailData() {
// TODO
//        addSubscribe(retrofitHelper.getVideoDetail()
//            .flatMap {
//                mView?.showVideoDetail(it.data)
//                retrofitHelper.getVideoDetailComment()
//            }
//            .compose(rxSchedulerHelper())
//            .subscribeWith(object : BaseSubscriber<VideoDetailComment>(mView) {
//                override fun onSuccess(t: VideoDetailComment) {
//                    mView?.showVideoDetailComment(t.data)
//                }
//            }))

        addSubscribe(
            Flowable.just(JsonUtils.readJson("videoDetail.json"))
                .map<VideoDetail> {
                    val gson = Gson()
                    val `object` = JsonParser().parse(it).asJsonObject
                    val array = `object`.getAsJsonObject("data")
                    val recommends = array.let { a-> gson.fromJson(it, VideoDetail::class.java) }
                    recommends
                }
                .compose(rxSchedulerHelper())
                .subscribeWith(object : BaseSubscriber<VideoDetail>(mView) {
                    override fun onSuccess(t: VideoDetail) {
                        mView?.showVideoDetail(t.data)
                    }
                }))

        addSubscribe(retrofitHelper.getVideoDetailComment()
            .compose(rxSchedulerHelper())
            .subscribeWith(object : BaseSubscriber<VideoDetailComment>(mView) {
                override fun onSuccess(t: VideoDetailComment) {
                    mView?.showVideoDetailComment(t.data)
                }
            }))
    }

}
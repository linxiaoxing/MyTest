package com.example.bilibilikotlin.network.helper

import com.example.bilibilikotlin.bean.app.Splash
import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment
import com.example.bilibilikotlin.bean.app.video.VideoPlayer
import com.example.bilibilikotlin.bean.discover.ActivityCenter
import com.example.bilibilikotlin.bean.live.LivePartition
import com.example.bilibilikotlin.bean.live.LiveRecommend
import com.example.bilibilikotlin.network.api.ApiService
import com.example.bilibilikotlin.network.api.AppService
import com.example.bilibilikotlin.network.api.LiveService
import com.example.bilibilikotlin.network.response.HttpResponse
import io.reactivex.Flowable

/**
 * * 描述:RetrofitHelper 帮助类
 */
class RetrofitHelper(private val appService: AppService,
                     private val apiService: ApiService,
                     private val liveService: LiveService) {

    fun getSplash(): Flowable<Splash> = appService.getSplash()

    fun getActivityCenter(page: Int, pageSize: Int): Flowable<ActivityCenter> = apiService.getActivityCenter(page, pageSize)

    fun getLivePartition(): Flowable<HttpResponse<LivePartition>> = liveService.getLivePartition()

    fun getLiveRecommend(): Flowable<HttpResponse<LiveRecommend>> = liveService.getLiveRecommend()

    fun getVideoDetail(): Flowable<VideoDetail> = appService.getVideoDetail()

    fun getVideoDetailComment(): Flowable<VideoDetailComment> = apiService.getVideoDetailComment()

    fun getVideoPlayer(): Flowable<VideoPlayer> = appService.getVideoPlayer()
}
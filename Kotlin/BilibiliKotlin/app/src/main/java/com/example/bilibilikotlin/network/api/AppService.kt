package com.example.bilibilikotlin.network.api

import com.example.bilibilikotlin.bean.app.Splash
import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoPlayer
import io.reactivex.Flowable
import retrofit2.http.GET

interface AppService {
    /**
     * splash界面
     * @return
     */
    @GET("/x/v2/splash?mobi_app=android&build=505000&channel=360&width=1080&height=1920&ver=4344558841496142006")
    fun getSplash(): Flowable<Splash>

    /**
     * 视频详情
     */
    @GET("/x/v2/view?access_key=18b6350cf0e8fb0cacb6cf323fc2feba&aid=3852397&appkey=1d8b6e7d45233436&build=505000&from=3&mobi_app=android&plat=0&platform=android&trackid=14859045423998458858&ts=1498645383&sign=94a3c4d143f44f023558ea52a33be403")
    fun getVideoDetail(): Flowable<VideoDetail>

    /**
     * 获取视频播放
     * @return
     */
    @GET("/playurl?device=android&qn=16&cid=6191437&appkey=iVGUTjsxvpLeuDCf&access_key=18b6350cf0e8fb0cacb6cf323fc2feba&otype=json&mid=117143614&build=505000&buvid=0ADC5B25-8C0A-4F6E-AE0C-83A3089CCEE223963infoc&platform=android&sign=153cb8fda95e5b1400cc3729d9a8afce")
    fun getVideoPlayer(): Flowable<VideoPlayer>

}
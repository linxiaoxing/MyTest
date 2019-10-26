package com.example.hmplayer.ui.activity

import com.example.hmplayer.R
import com.example.hmplayer.base.BaseActivity
import com.example.hmplayer.model.VideoPlayBean
import io.vov.vitamio.Vitamio
import kotlinx.android.synthetic.main.activity_video_player_vitamio.*

class VitamioVideoPlayerActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_vitamio
    }

    override fun initData() {
        // 初始化Vitamio
        Vitamio.isInitialized(this)

        // 获取数据
        val videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        videoView.setVideoPath(videoPlayBean.url) // 异步准备
        videoView.setOnPreparedListener {
            videoView.start()
        }
    }

    override fun onDestroy() {
        videoView.stopPlayback()
        super.onDestroy()
    }
}
package com.example.hmplayer.ui.activity

import com.example.hmplayer.R
import com.example.hmplayer.base.BaseActivity
import com.example.hmplayer.model.VideoPlayBean
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_video_player
    }

    override fun initData() {
        // 获取数据
        val videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        //val url = intent.getStringExtra("url")
        videoView.setVideoPath(videoPlayBean.url)
        videoView.setOnPreparedListener {
            videoView.start()
        }
    }

    override fun onDestroy() {
        videoView.stopPlayback()
        super.onDestroy()
    }
}
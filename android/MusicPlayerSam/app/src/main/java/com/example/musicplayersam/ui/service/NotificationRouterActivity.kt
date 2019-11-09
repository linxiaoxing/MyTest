package com.example.musicplayersam.ui.service

import android.content.Intent
import android.os.Bundle
import com.example.musicplayersam.player.MusicPlayerManager
import com.example.musicplayersam.player.playlist.Playlist
import com.example.musicplayersam.ui.activity.base.BaseActivity

/**
 * RouterActivity for Notification to open player fragment
 *
 */
class NotificationRouterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pl = MusicPlayerManager.musicPlayer.playlist.token

        if (pl == Playlist.TOKEN_FM) {
            //TODO
            // startActivity(Intent(this, AppMainActivity::class.java))
        } else {
            // startActivity(Intent(this, MusicPlayerActivity::class.java))
        }
        finish()
    }

}
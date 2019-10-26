package com.example.hmplayer.service

import com.example.hmplayer.model.AudioBean

interface IService {
    fun updatePlayState()
    fun isPlaying(): Boolean?
    fun getDuration(): Int
    fun getProgress(): Int
    fun seekTo(progress: Int)
    fun updatePlayMode()
    fun getPlayMode(): Int
    fun playPre()
    fun playNext()
    fun getPlayList(): List<AudioBean>?
    fun playPosition(position: Int)
}
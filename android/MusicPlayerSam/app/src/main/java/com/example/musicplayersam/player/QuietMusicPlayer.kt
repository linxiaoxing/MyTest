package com.example.musicplayersam.player

import com.example.musicplayersam.player.core.IMediaPlayer
import com.example.musicplayersam.player.core.QuietMediaPlayer
import com.example.musicplayersam.player.playlist.Playlist
import com.example.musicplayersam.repository.LatestPlayingRepository
import com.example.musicplayersam.utils.component.LoggerLevel
import com.example.musicplayersam.utils.component.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.soit.quiet.model.vo.Music
import kotlin.properties.Delegates

/**
 * provide method could directly interaction with UI
 */
class QuietMusicPlayer {

    companion object {
        const val DURATION_UPDATE_PROGRESS = 200L
    }

    /**
     * @see IMediaPlayer
     */
    val mediaPlayer: IMediaPlayer = QuietMediaPlayer()

    /**
     * @see Playlist
     */
    var playlist: Playlist by Delegates.observable(Playlist.EMPTY) { _, oldValue, newValue ->
        newValue.playMode = oldValue.playMode//inherit old playlist play mode

        //LiveData change
        MusicPlayerManager.playlist.postValue(newValue)
        MusicPlayerManager.playingMusic.postValue(playlist.current)

        //stop player
        if (newValue != oldValue) {
            quiet()
        }
    }

    /**
     * play the music which return by [Playlist.getNext]
     */
    fun playNext() = safeAsync {
        val next =playlist.getNext()
        if (next == null) {
            log(LoggerLevel.WARN) { "next music is null" }
            return@safeAsync
        }
        play(next)
    }

    /**
     * stop play
     */
    fun quiet() {
        mediaPlayer.release()
    }


    private fun safeAsync(block: suspend () -> Unit) {
        GlobalScope.launch(Dispatchers.Main) { block() }
    }

    /**
     * if is playing , pause
     * if is not playing , playing current music
     */
    fun playPause() = safeAsync {
        val current = playlist.current
        if (current == null) {
            playNext()
            return@safeAsync
        }
        if (current != MusicPlayerManager.playingMusic.value) {
            MusicPlayerManager.playingMusic.postValue(current)
        }
        if (mediaPlayer.getState() == IMediaPlayer.IDLE) {
            play(current)
        } else {
            mediaPlayer.isPlayWhenReady = !mediaPlayer.isPlayWhenReady
        }
    }

    /**
     * play the music which return by [Playlist.getPrevious]
     */
    fun playPrevious() = safeAsync {
        val previous = playlist.getPrevious()
        if (previous == null) {
            log(LoggerLevel.WARN) { "previous is null , op canceled!" }
            return@safeAsync
        }
        play(previous)
    }

    /**
     * play [music] , if music is not in [playlist] , insert ot next
     */
    fun play(music: Music, playWhenReady: Boolean = true) {
        if (!playlist.list.contains(music)) {
            playlist.insertToNext(music)
        }
        log { "try to play $music" }
        playlist.current = music

        //live data playing music changed
        MusicPlayerManager.playingMusic.postValue(music)
        LatestPlayingRepository.getInstance().hit(music)

        val url = "http://mp3.9ku.com/m4a/411603.m4a"
        // val uri = music.getPlayUrl()
        mediaPlayer.prepare(url, playWhenReady)
    }

    init {

        //indefinite to emit current playing music' duration and playing position
        //maybe have a cleverer way to do that!!
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                delay(DURATION_UPDATE_PROGRESS)
                try {
                    val notify = playlist.current != null
                            && mediaPlayer.getState() == IMediaPlayer.PLAYING

                    if (notify) {
                        MusicPlayerManager.position
                            .postValue(IMusicPlayerManager.Position(mediaPlayer.getPosition(),
                                mediaPlayer.getDuration()))
                    }
                } catch (e: Exception) {
                    //ignore
                }
            }
        }

        //to auto play next
        mediaPlayer.setOnCompleteListener {
            playNext()
        }

    }

}
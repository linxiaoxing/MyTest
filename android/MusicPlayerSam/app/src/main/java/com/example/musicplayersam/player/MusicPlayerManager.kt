package com.example.musicplayersam.player

import androidx.lifecycle.MutableLiveData
import com.example.musicplayersam.player.core.IMediaPlayer
import com.example.musicplayersam.player.playlist.Playlist
import com.example.musicplayersam.ui.service.QuietPlayerService
import com.example.musicplayersam.utils.component.persistence.KeyValue
import com.example.musicplayersam.utils.component.support.liveDataWith
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tech.soit.quiet.model.vo.Music


/**
 *
 * use [MusicPlayerManager]
 *
 * provider [musicPlayer] to access [IMediaPlayer] , [Playlist]
 * and play action such as :
 * [QuietMusicPlayer.playNext],
 * [QuietMusicPlayer.playPrevious],
 * [QuietMusicPlayer.playPause]
 *
 * provider LiveData such as [playingMusic] [position] [playerState] [playlist]
 * to listen MusicPlayer' state
 *
 * provider [play] method for convenience to play music
 *
 */
interface IMusicPlayerManager {


    var musicPlayer: QuietMusicPlayer

    val playingMusic: MutableLiveData<Music?>

    val position: MutableLiveData<Position>


    val playerState: MutableLiveData<Int>

    val playlist: MutableLiveData<Playlist>

    fun play(token: String, music: Music, list: List<Music>)


    /**
     * unit is Millisecond
     *
     * @param current the current playing position
     * @param total music total length
     */
    data class Position(val current: Long, val total: Long)
}

class MusicPlayerManagerImpl : IMusicPlayerManager {

    companion object {


        /**
         * keys use to save PlaylistData to Db
         *
         * [KEY_PLAYLIST_CURRENT] : current playing music
         * [KEY_PLAYLIST_MUSIC_LIST] : current playing music list
         * [KEY_PLAYLIST_TOKEN] : token to identify this music list
         * [KEY_PLAYLIST_PLAY_MODE] : [PlayMode]
         *
         */
        const val KEY_PLAYLIST_MUSIC_LIST = "player_playlist_key_music_list"
        const val KEY_PLAYLIST_TOKEN = "player_playlist_key_token"
        const val KEY_PLAYLIST_CURRENT = "player_playlist_key_current"
        const val KEY_PLAYLIST_PLAY_MODE = "play_playlist_key_play_mode"

    }

    /**
     * music player, manage the playlist and [IMediaPlayer]
     *
     * ATTENTION: setter is only for TEST!!
     *
     */
    override var musicPlayer = QuietMusicPlayer()

    /**
     * current playing music live data
     */
    override val playingMusic = liveDataWith(musicPlayer.playlist.current)

    override val position = MutableLiveData<IMusicPlayerManager.Position>()

    /**
     * @see IMediaPlayer.PlayerState
     */
    override val playerState = liveDataWith(IMediaPlayer.IDLE)

    init {
        musicPlayer.mediaPlayer.setOnStateChangeCallback {
            playerState.postValue(it)
        }
    }

    override val playlist = MutableLiveData<Playlist>()

    /**
     * @param token [Playlist.token]
     * @param music the music which will be play
     * @param list the music from
     */
    override fun play(token: String, music: Music, list: List<Music>) {
        val newPlaylist = Playlist(token, list)
        newPlaylist.current = music
        musicPlayer.playlist = newPlaylist
        musicPlayer.play(music)
    }

    init {
        //restore Playlist for MusicPlayer
        GlobalScope.launch Restore@{
            val token = KeyValue.get<String>(KEY_PLAYLIST_TOKEN, String::class.java)
            val musics: List<Music>? = KeyValue.objectFromString(KeyValue.get(KEY_PLAYLIST_MUSIC_LIST, Array<Music>::class.java)
                ?: return@Restore)

            if (token != null && musics != null) {
                val playMode = KeyValue.get<String>(KEY_PLAYLIST_PLAY_MODE, String::class.java)
                val current: Music? = KeyValue.objectFromString(KeyValue.get(KEY_PLAYLIST_CURRENT, Music::class.java))

                val restore = Playlist(token, musics)
                restore.current = current
                restore.playMode = PlayMode.from(playMode)
                musicPlayer.playlist = restore
            }
        }

        //persistence playlist
        playlist.observeForever { pl ->
            pl ?: return@observeForever
            GlobalScope.launch {
                KeyValue.put(KEY_PLAYLIST_TOKEN, pl.token)
                KeyValue.put(KEY_PLAYLIST_CURRENT, KeyValue.objectToString(pl.current))
                KeyValue.put(KEY_PLAYLIST_PLAY_MODE, pl.playMode)
                KeyValue.put(KEY_PLAYLIST_MUSIC_LIST, KeyValue.objectToString(ArrayList(pl.list)))
            }
        }

        //persistence playing music
        playingMusic.observeForever { m ->
            m ?: return@observeForever
            GlobalScope.launch {
                KeyValue.put(KEY_PLAYLIST_CURRENT, KeyValue.objectToString(m))
            }
        }
        QuietPlayerService.init(playerState)
    }
}

object MusicPlayerManager : IMusicPlayerManager by MusicPlayerManagerImpl()
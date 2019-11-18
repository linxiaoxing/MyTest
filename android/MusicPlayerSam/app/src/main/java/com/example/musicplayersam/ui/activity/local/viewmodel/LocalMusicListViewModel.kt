package com.example.musicplayersam.ui.activity.local.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayersam.repository.db.QuietDatabase
import com.example.musicplayersam.repository.db.dao.LocalMusicDao
import tech.soit.quiet.model.vo.Album
import tech.soit.quiet.model.vo.Artist
import tech.soit.quiet.model.vo.Music

class LocalMusicListViewModel(
    private val dao: LocalMusicDao = QuietDatabase.instance.localMusicDao()
) : ViewModel() {


    /**
     * get local music by artist
     */
    fun getMusicListByArtist(artist: Artist): LiveData<List<Music>> {
        @Suppress("UNCHECKED_CAST")
        return dao.getMusicsByArtist(artist.getName()) as LiveData<List<Music>>
    }


    /**
     * get local music by album
     */
    fun getMusicListByAlbum(album: Album): LiveData<List<Music>> {
        @Suppress("UNCHECKED_CAST")
        return dao.getMusicsByAlbum(album.getName()) as LiveData<List<Music>>
    }


}
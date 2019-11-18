package com.example.musicplayersam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayersam.repository.db.QuietDatabase
import com.example.musicplayersam.repository.db.dao.LocalMusicDao
import com.example.musicplayersam.utils.component.support.mapNonNull
import tech.soit.quiet.model.vo.Album
import tech.soit.quiet.model.vo.Artist
import tech.soit.quiet.model.vo.Music

class LocalMusicViewModel constructor(
    private val localMusicDao: LocalMusicDao = QuietDatabase.instance.localMusicDao()
) : ViewModel() {

    /**
     * local total musics
     */
    val allMusics: LiveData<List<Music>>
    @Suppress("UNCHECKED_CAST")
    get() = localMusicDao.getAllMusics() as LiveData<List<Music>>

    /**
     * local total albums
     */
    val allAlbums: LiveData<List<Album>>
        get() = allMusics.mapNonNull { musics ->
            musics.asSequence().map { it.getAlbum() }.distinctBy { it.getName() }.toList()
        }

    /**
     * local total artist
     */
    val allArtists: LiveData<List<Artist>>
        get() = allMusics.mapNonNull { musics ->
            musics.flatMap { it.getArtists() }.distinctBy { it.getName() }
        }

}
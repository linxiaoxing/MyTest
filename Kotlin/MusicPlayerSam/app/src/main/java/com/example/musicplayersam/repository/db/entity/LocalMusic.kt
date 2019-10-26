package com.example.musicplayersam.repository.db.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.musicplayersam.model.local.LocalAlbum
import com.example.musicplayersam.model.local.LocalArtist
import com.example.musicplayersam.model.vo.Album
import com.example.musicplayersam.model.vo.Artist
import com.example.musicplayersam.model.vo.Music

@Entity(
    tableName = "local_music",
    indices = [
        Index(
            value = ["fileUri"], unique = true
        ),
        Index(
            value = ["albumString"], unique = false
        ),
        Index(
            value = ["artistString"], unique = false
        )]
)

data class LocalMusic(
    @PrimaryKey(autoGenerate = true)
    private val id: Long,

    /**
     * file path;
     * unique uri, start with file://
     */
    val fileUri: String,

    /**
     * song title
     */
    private val title: String,

    /**
     * song album
     */
    val albumString: String,

    /**
     * artist
     */
    val artistString: String

) : Music() {

    override fun getId(): Long {
        return id
    }

    @Ignore
    override fun getAlbum(): Album {
        return LocalAlbum(albumString, "")
    }

    @Ignore
    override fun getArtists(): List<Artist> {
        return listOf(LocalArtist(artistString))
    }

    override fun getTitle(): String {
        return title
    }

    @Ignore
    override fun getPlayUrl(): String {
        return fileUri
    }

}

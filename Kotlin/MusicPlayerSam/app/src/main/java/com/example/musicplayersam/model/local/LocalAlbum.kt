package com.example.musicplayersam.model.local

import com.example.musicplayersam.model.vo.Album

class LocalAlbum(
    private val name: String,
    private val coverImageUrl: String
) : Album() {

    override fun getCoverImageUrl(): Any {
        return coverImageUrl
    }

    override fun getName(): String {
        return name
    }

    override fun getId(): Long {
        return 0 /*local album do not have id yet*/
    }
}
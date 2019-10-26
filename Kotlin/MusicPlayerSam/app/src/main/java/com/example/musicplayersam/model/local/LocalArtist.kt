package com.example.musicplayersam.model.local

import com.example.musicplayersam.model.vo.Artist
import kotlinx.android.parcel.Parcelize

class LocalArtist(
    private val name: String
) : Artist() {

    override fun getId(): Long {
        return 0 /* local artist do not have id yet */
    }

    override fun getName(): String {
        return name
    }
}
package com.example.musicplayersam.model.vo

import java.io.Serializable

abstract class Album : Serializable {


    abstract fun getCoverImageUrl(): Any?

    abstract fun getName(): String

    abstract fun getId(): Long

}
package com.example.musicplayersam.model.vo

import java.io.Serializable

abstract class Artist : Serializable {

    abstract fun getId(): Long

    abstract fun getName(): String

}
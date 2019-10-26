package com.example.musicplayersam.model.po

import com.example.musicplayersam.model.vo.User
import com.example.musicplayersam.repository.netease.source.NeteaseGlideUrl

data class NeteaseUser(
    private val id: Long,
    private val nickname: String,
    private val avatarUrl: String
) : User() {

    override fun getNickName(): String {
        return nickname
    }

    override fun getAvatarUrl(): Any {
        return NeteaseGlideUrl(avatarUrl)
    }

    override fun getId(): Long {
        return id
    }

}

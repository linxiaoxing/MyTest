package tech.soit.quiet.model.po

import com.example.musicplayersam.repository.netease.source.NeteaseGlideUrl
import tech.soit.quiet.model.vo.User

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
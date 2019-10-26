package com.example.musicplayersam.repository.netease

import androidx.lifecycle.ViewModel
import com.example.musicplayersam.model.po.NeteaseUser
import com.example.musicplayersam.model.vo.User
import com.example.musicplayersam.utils.component.persistence.KeyValue

class NeteaseRepository(
    private val service: CloudMusicService = CloudMusicServiceProvider.provideCloudMusicService()
) : ViewModel() {

    companion object {

        val instance = NeteaseRepository()

        private const val KEY_USER = "netease_repository_user"

        private const val REMOTE_KEY_MESSAGE = "msg"

    }

    /**
     * @return null when no user login
     */
    fun getLoginUser(): User? {
        return KeyValue.get<NeteaseUser>(KEY_USER, null)
    }

}
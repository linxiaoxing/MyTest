package com.example.musicplayersam.ui.activity.user.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicplayersam.repository.netease.NeteaseRepository

class LoginViewModel(
    private val neteaseRepository: NeteaseRepository = NeteaseRepository.instance
) : ViewModel() {

    /**
     * login to netease
     */
    suspend fun login(phone: String?, password: String?): LoginResult {
        if (phone == null || password == null) {
            return LoginResult(false, "空输入")
        }

        return try {
            neteaseRepository.login(phone, password)
            LoginResult(true, null)
        } catch (e: Exception) {
            LoginResult(false, e.message ?: "Unknown")
        }
    }

    data class LoginResult(val isSuccess: Boolean,
                           val msg: String?)
}
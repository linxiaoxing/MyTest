package com.example.musicplayersam.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicplayersam.repository.netease.NeteaseRepository
import tech.soit.quiet.model.vo.User

abstract class CloudViewModel : ViewModel() {

    protected val repository: NeteaseRepository get() = NeteaseRepository.instance

    /**
     * current user
     */
    fun getLoginUser(): User? {
        return repository.getLoginUser()
    }
}
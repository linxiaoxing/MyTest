package com.example.musicplayersam.ui.fragment.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicplayersam.repository.netease.NeteaseRepository

class MainMusicViewModel : ViewModel() {

    fun getNeteaseRepository(): NeteaseRepository {
        return NeteaseRepository.instance
    }

}
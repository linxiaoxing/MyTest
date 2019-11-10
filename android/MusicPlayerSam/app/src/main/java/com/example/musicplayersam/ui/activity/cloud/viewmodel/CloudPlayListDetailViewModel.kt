package com.example.musicplayersam.ui.activity.cloud.viewmodel

import com.example.musicplayersam.viewmodel.CloudViewModel
import tech.soit.quiet.model.vo.PlayListDetail

class CloudPlayListDetailViewModel : CloudViewModel() {

    suspend fun loadData(id: Long): PlayListDetail? {
        return try {
            repository.playListDetail(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
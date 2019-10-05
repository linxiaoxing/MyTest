package com.example.gsykotlin.repository

import android.app.Application
import com.example.gsykotlin.repository.dao.ReposDao
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 仓库相关数据获取
 */
class ReposRepository @Inject constructor(private val retrofit: Retrofit, private val application: Application, private val reposDao: ReposDao) {

    companion object {
        const val STAR_KEY = "starred"
        const val WATCH_KEY = "watched"
    }

}
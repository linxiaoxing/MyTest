package com.example.gsykotlin.repository

import android.app.Application
import com.example.gsykotlin.common.config.AppConfig
import com.example.gsykotlin.common.utils.GSYPreference
import com.example.gsykotlin.model.AppGlobalModel
import com.example.gsykotlin.repository.dao.UserDao
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 用户相关数据获取
 */
class UserRepository @Inject constructor(private val retrofit: Retrofit, private val appGlobalModel: AppGlobalModel,
                                         private val application: Application, private val userDao: UserDao) {

    /**
     * 登录用户的 SharedPreferences 委托
     */
    private var userInfoStorage: String by GSYPreference(AppConfig.USER_INFO, "")



}
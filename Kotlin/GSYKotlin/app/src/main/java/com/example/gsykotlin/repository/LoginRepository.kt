package com.example.gsykotlin.repository

import com.example.gsykotlin.common.config.AppConfig
import com.example.gsykotlin.common.utils.GSYPreference
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 登录数据仓库对象
 */
class LoginRepository @Inject constructor(private val retrofit: Retrofit, private val userRepository: UserRepository) {

    private var usernameStorage: String by GSYPreference(AppConfig.USER_NAME, "")

    private var passwordStorage: String by GSYPreference(AppConfig.PASSWORD, "")

    private var accessTokenStorage: String by GSYPreference(AppConfig.ACCESS_TOKEN, "")

    private var userBasicCodeStorage: String by GSYPreference(AppConfig.USER_BASIC_CODE, "")

    private var userInfoStorage: String by GSYPreference(AppConfig.USER_INFO, "")

}
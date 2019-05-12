package com.example.chen.usercenter.service

import com.example.chen.usercenter.data.protocol.UserInfo
import rx.Observable


interface UserService {
    //返回Observable,判断成功失败
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>

    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo>
    fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean>
    fun resetPwd(mobile: String, pwd: String): Observable<Boolean>
    //编辑用户资料
    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo>
}
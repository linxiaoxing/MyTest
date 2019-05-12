package com.example.chen.usercenter.repository

import com.example.chen.baselibrary.data.net.RetrofitFactory
import com.example.chen.baselibrary.data.protocol.BaseResp
import com.example.chen.usercenter.data.api.UserApi
import com.example.chen.usercenter.data.protocol.*
import rx.Observable
import javax.inject.Inject

/**
 * 访问数据
 */
class UserRepository @Inject constructor() {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, pwd, verifyCode))
    }

    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(mobile, pwd, pushId))
    }

    fun forgetPwd(mobile: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .forgetPwd(ForgetPwdReq(mobile, verifyCode))
    }

    fun resetPwd(mobile: String, pwd: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .resetPwd(ResetPwdReq(mobile, pwd))
    }

    /**
     * 编辑用户资料
     */
    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java).editUser(EditUserReq(userIcon, userName, userGender, userSign))
    }
}
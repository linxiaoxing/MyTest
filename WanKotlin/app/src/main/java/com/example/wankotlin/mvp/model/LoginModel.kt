package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.LoginContract
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.LoginData
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/5/27.
 */
class LoginModel : BaseModel(), LoginContract.Model {

    override fun loginWanAndroid(username: String, password: String): Observable<HttpResult<LoginData>> {
        return RetrofitHelper.service.loginWanAndroid(username, password)
    }

}
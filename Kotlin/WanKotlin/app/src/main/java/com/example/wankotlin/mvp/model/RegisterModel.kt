package com.example.wankotlin.mvp.model

import com.example.wankotlin.base.BaseModel
import com.example.wankotlin.http.RetrofitHelper
import com.example.wankotlin.mvp.contract.RegisterContract
import com.example.wankotlin.mvp.model.bean.HttpResult
import com.example.wankotlin.mvp.model.bean.LoginData
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/6/3.
 */
class RegisterModel : BaseModel(), RegisterContract.Model {

    override fun registerWanAndroid(username: String, password: String, repassword: String): Observable<HttpResult<LoginData>> {
        return RetrofitHelper.service.registerWanAndroid(username, password, repassword)
    }

}
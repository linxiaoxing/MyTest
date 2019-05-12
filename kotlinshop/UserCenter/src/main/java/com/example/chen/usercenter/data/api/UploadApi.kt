package com.example.chen.usercenter.data.api

import com.example.chen.baselibrary.data.protocol.BaseResp
import com.example.chen.usercenter.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UploadApi {
    @POST("common/getUploadToken")
    fun getUploadToken():Observable<BaseResp<String>>

}
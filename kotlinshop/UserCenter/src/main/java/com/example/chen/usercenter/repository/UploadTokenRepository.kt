package com.example.chen.usercenter.repository

import com.example.chen.baselibrary.data.net.RetrofitFactory
import com.example.chen.baselibrary.data.protocol.BaseResp
import com.example.chen.usercenter.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

class UploadTokenRepository @Inject constructor(){
    fun getUploadToken():Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UploadApi::class.java)
                .getUploadToken()
    }

}
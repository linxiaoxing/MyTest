package com.example.chen.usercenter.service.impl

import com.example.chen.baselibrary.ext.convert
import com.example.chen.usercenter.repository.UploadTokenRepository
import com.kotlin.user.service.UploadService
import rx.Observable
import javax.inject.Inject

class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var repository: UploadTokenRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }

}
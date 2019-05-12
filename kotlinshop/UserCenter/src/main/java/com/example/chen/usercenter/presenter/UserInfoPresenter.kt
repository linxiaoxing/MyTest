package com.example.chen.usercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.chen.usercenter.data.protocol.UserInfo
import com.example.chen.usercenter.presenter.view.UserInfoView
import com.example.chen.usercenter.service.impl.UploadServiceImpl
import com.example.chen.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var userServiceImpl: UserServiceImpl;
    @Inject
    lateinit var uploadServiceImpl: UploadServiceImpl
    fun getUploadToken() {
        uploadServiceImpl.getUploadToken().excute(object : BaseSubscriber<String>(mView) {
            override fun onNext(t: String) {
              mView.onGetUploadTokenResult(t)
            }
        }, lifecycleProvider)
    }
    /**
     * 编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork())
            return

        mView.showLoading()
        userServiceImpl.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        },lifecycleProvider)
    }
}
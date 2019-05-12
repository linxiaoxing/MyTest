package com.example.chen.usercenter.presenter.view

import com.example.chen.baselibrary.presenter.view.BaseView
import com.example.chen.usercenter.data.protocol.UserInfo

interface UserInfoView: BaseView {
    fun onGetUploadTokenResult(result:String)
    /*
       编辑用户资料回调
    */
    fun onEditUserResult(result: UserInfo)
}
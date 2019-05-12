package com.example.chen.usercenter.presenter.view

import com.example.chen.baselibrary.presenter.view.BaseView
import com.example.chen.usercenter.data.protocol.UserInfo

interface LoginView: BaseView {
    fun onLoginResult(result:UserInfo);
}
package com.example.chen.usercenter.presenter.view

import com.example.chen.baselibrary.presenter.view.BaseView

interface RegisterView: BaseView {
    fun onRegisterResult(result:String);
}
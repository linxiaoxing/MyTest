package com.example.chen.baselibrary.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun error(text:String)
}
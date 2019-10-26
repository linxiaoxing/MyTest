package com.example.hmplayer.view

import com.example.hmplayer.model.MvAreaBean

interface MvView {

    fun onError(msg: String?)
    fun onSuccess(result: List<MvAreaBean>?)
}
package com.example.hmplayer.view

import com.example.hmplayer.model.HomeItemBean

interface HomeView {

    fun onError(message: String?)

    fun loadSuccessed(list: List<HomeItemBean>?)

    fun loadMoreSuccessed(list: List<HomeItemBean>?)
}
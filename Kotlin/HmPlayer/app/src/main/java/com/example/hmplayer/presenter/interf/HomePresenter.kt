package com.example.hmplayer.presenter.interf

interface HomePresenter {

    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2
    }

    fun loadMore(offset: Int)
    fun loadDatas()

}
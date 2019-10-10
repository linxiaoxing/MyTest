package com.example.hmplayer.ui.fragment

import com.example.hmplayer.adapter.HomeAdapter
import com.example.hmplayer.base.*
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.presenter.impl.HomePresenterImpl

import com.example.hmplayer.view.HomeItemView


class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>(){
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }


}
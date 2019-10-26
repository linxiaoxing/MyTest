package com.example.hmplayer.presenter.impl

import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.MvAreaBean
import com.example.hmplayer.net.MvAreaRequest
import com.example.hmplayer.net.ResponseHandler
import com.example.hmplayer.presenter.interf.MvPresenter
import com.example.hmplayer.view.MvView

class MvPresenterImpl(var mvView: MvView, val fragment: BaseFragment): MvPresenter, ResponseHandler<List<MvAreaBean>> {

    override fun onError(msg: String?) {
       mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
       mvView.onSuccess(result)
    }

    override fun loadData() {
      MvAreaRequest(this, fragment).execute()
    }
}
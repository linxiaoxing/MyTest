package com.example.hmplayer.presenter.impl

import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.base.BaseView
import com.example.hmplayer.model.MvPagerBean
import com.example.hmplayer.model.VideosBean
import com.example.hmplayer.net.MvListRequest
import com.example.hmplayer.net.ResponseHandler
import com.example.hmplayer.presenter.interf.MvListPresenter

class MvListPresenterImpl(var code: String, var mvListView: BaseView<List<VideosBean>>?) : MvListPresenter,
    ResponseHandler<MvPagerBean> {


    override fun loadData() {
        MvListRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH, code, 0, this).execute()
    }

    override fun loadMore(offset: Int) {
        MvListRequest(BaseListPresenter.TYPE_LOAD_MORE, code, offset, this).execute()
    }

    override fun destroyView() {
        if (mvListView != null) {
            mvListView = null
        }
    }

    override fun onError(msg: String?) {
        mvListView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: MvPagerBean) {
        when (type) {
            BaseListPresenter.TYPE_INIT_OR_REFRESH -> mvListView?.onLoadDataSuccess(result.videos)
            BaseListPresenter.TYPE_LOAD_MORE -> mvListView?.onLoadMoreSuccess(result.videos)
        }
    }


}
package com.example.hmplayer.presenter.impl

import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.model.MvPagerBean
import com.example.hmplayer.net.MvListRequest
import com.example.hmplayer.net.ResponseHandler
import com.example.hmplayer.view.MvListView

class BaseListPresenterImpl(var code: String, var mvListView: MvListView?) : BaseListPresenter,
    ResponseHandler<MvPagerBean> {

    override fun onError(msg: String?) {
      mvListView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: MvPagerBean) {
        if (type == BaseListPresenter.TYPE_INIT_OR_REFRESH) {
            mvListView?.onLoadDataSuccess(result)
        } else {
            mvListView?.onLoadMoreSuccess(result)
        }
    }

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


}
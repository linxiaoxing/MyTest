package com.example.hmplayer.presenter.impl

import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.net.ResponseHandler
import com.example.hmplayer.net.YueDanRequest
import com.example.hmplayer.presenter.interf.YueDanPresenter
import com.example.hmplayer.view.YueDanView

class YueDanPresenterImpl(var view: YueDanView?): YueDanPresenter, ResponseHandler<YueDanBean> {
    override fun destroyView() {
        if (view != null) {
            view = null
        }
    }

    override fun loadMore(offset: Int) {

        YueDanRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH, offset, this).execute()
    }

    override fun loadData() {
        YueDanRequest(BaseListPresenter.TYPE_LOAD_MORE, 0, this).execute()
    }

    override fun onError(msg: String?) {
        view?.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        if (type == BaseListPresenter.TYPE_INIT_OR_REFRESH) {
            view?.onLoadDataSuccess(result)
        } else {
            view?.onLoadMoreSuccess(result)
        }
    }

}
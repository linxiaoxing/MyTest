package com.example.hmplayer.ui.fragment

import com.example.hmplayer.adapter.YueDanAdapter
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.base.BaseListFragment
import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.model.VideoPlayBean
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.presenter.impl.YueDanPresenterImpl
import com.example.hmplayer.ui.activity.VideoPlayerActivity
import com.example.hmplayer.ui.activity.VitamioVideoPlayerActivity
import com.example.hmplayer.widget.YueDanItemView
import org.jetbrains.anko.support.v4.startActivity


class YueDanFragment : BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {

    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this, this)
    }

    override fun setListener() {
        // 设置条目点击事件
        adapter.setMyListener {
            startActivity<VitamioVideoPlayerActivity>(
                "item" to VideoPlayBean(
                    1,
                    "big_buck_bunny",
                    "http://file.kuyinyun.com/group1/M00/90/B7/rBBGdFPXJNeAM-nhABeMElAM6bY151.mp3"
                )
            )
        }
        // "http://file.kuyinyun.com/group1/M00/90/B7/rBBGdFPXJNeAM-nhABeMElAM6bY151.mp3"
    }

}
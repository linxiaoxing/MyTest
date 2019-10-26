package com.example.hmplayer.ui.fragment

import com.example.hmplayer.adapter.HomeAdapter
import com.example.hmplayer.base.*
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.presenter.impl.HomePresenterImpl
import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.model.AudioBean
import com.example.hmplayer.ui.activity.AudioPlayerActivity

import com.example.hmplayer.widget.HomeItemView
import org.jetbrains.anko.support.v4.startActivity


class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this, this)
    }

    override fun setListener() {
//        // 设置条目点击事件
//        adapter.setMyListener {
//            startActivity<VideoPlayerActivity>("item" to VideoPlayBean(1, "big_buck_bunny", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"))
//        }
        //val cursor = adapter!!.getItem(position) as Cursor
        adapter.setMyListener {
            val list = getAudioBean()
            startActivity<AudioPlayerActivity>("list" to list, "position" to 0)
        }
    }

    fun getAudioBean(): ArrayList<AudioBean> {
        //创建audiobean对象
        val list = ArrayList<AudioBean>()
        val audioBean = AudioBean("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", 0, "test1", "linxiaoxing")
        val audioBean2 = AudioBean("http://file.kuyinyun.com/group1/M00/90/B7/rBBGdFPXJNeAM-nhABeMElAM6bY151.mp3", 0, "test2", "xuemingqin")
        val audioBean3 = AudioBean("https://media.w3.org/2010/05/sintel/trailer.mp4", 0, "test3", "xuemingqin")
        list.add(audioBean)
        list.add(audioBean2)
        list.add(audioBean3)
        return list
    }
}
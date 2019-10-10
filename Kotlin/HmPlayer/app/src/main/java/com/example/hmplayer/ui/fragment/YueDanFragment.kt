package com.example.hmplayer.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hmplayer.R
import com.example.hmplayer.adapter.YueDanAdapter
import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.presenter.impl.YueDanPresenterImpl
import com.example.hmplayer.view.YueDanView
import kotlinx.android.synthetic.main.fragment_list.*

class YueDanFragment : BaseFragment(), YueDanView {

    val presenter by lazy { YueDanPresenterImpl(this) }
    val adapter by lazy { YueDanAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
    }

    override fun initData() {
        presenter.loadData()
    }

    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun onLoadDataSuccess(list: YueDanBean?) {
        adapter.updateList(list?.playLists)
    }

    override fun onLoadMoreSuccess(list: YueDanBean?) {

    }

}
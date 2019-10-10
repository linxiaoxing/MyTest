package com.example.hmplayer.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.R
import com.example.hmplayer.adapter.HomeAdapter
import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.base.BaseView
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.presenter.impl.HomePresenterImpl
import com.example.hmplayer.presenter.interf.HomePresenter
import com.example.hmplayer.util.ThreadUtil
import com.example.hmplayer.util.URLProviderUtils
import com.example.hmplayer.view.HomeItemView
import com.example.hmplayer.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_list.*
import okhttp3.*
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast
import java.io.IOException

class HomeFragment : BaseFragment(), BaseView<List<HomeItemBean>> {

    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter

        // 更新の初期処理
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        refreshLayout.setOnRefreshListener {
            presenter.loadData()
        }

        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                when(newState) {
//                    RecyclerView.SCROLL_STATE_IDLE-> {
//                        println("idle")
//                    }
//                    RecyclerView.SCROLL_STATE_DRAGGING-> {
//                        println("dragging")
//                    }
//                    RecyclerView.SCROLL_STATE_SETTLING-> {
//                        println("setting")
//                    }
//                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPositoin = manager.findLastVisibleItemPosition()
                        if (lastPositoin == adapter.itemCount - 1) {
                            presenter.loadMore(adapter.itemCount -1)
                        }
                    }

                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                println("dx: $dx, dy: $dy")
            }
        })

    }

    override fun initData() {
        // loadDatas()
        presenter.loadData()
    }

    override fun onError(message: String?) {
        myToast("获取数据出错：" + Thread.currentThread().name)
        runOnUiThread { refreshLayout.isRefreshing = false }
    }

    override fun onLoadDataSuccess(list: List<HomeItemBean>?) {
        runOnUiThread { refreshLayout.isRefreshing = false }
        adapter.updateList(list)
    }

    override fun onLoadMoreSuccess(list: List<HomeItemBean>?) {
        adapter.loadMore(list)

    }

}
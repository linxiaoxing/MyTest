package com.example.waneye.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.waneye.R
import com.example.waneye.adapter.HomeAdatper
import com.example.waneye.mvp.contract.HomeContract
import com.example.waneye.mvp.model.bean.HomeBean
import com.example.waneye.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.regex.Pattern

class HomeFragment : BaseFragment(), HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    var mIsRefresh: Boolean = false

    private val mPresenter: HomePresenter by lazy {
        HomePresenter(context!!, this)
    }

    private var mList = mutableListOf<HomeBean.IssueListBean.ItemListBean>()

    private val mAdapter: HomeAdatper by lazy {
        HomeAdatper(context!!, this.mList)
    }

    private lateinit var data: String

    override fun setData(bean: HomeBean) {
        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(bean?.nextPageUrl)
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }

        }
        bean.issueList!!
            .flatMap { it.itemList!! }
            .filter { it.type.equals("video") }
            .forEach { mList.add(it) }
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int = R.layout.home_fragment

    override fun initView() {
        mPresenter?.start()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter
        refreshLayout.setOnRefreshListener(this)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList.size - 1) {
                    if (data != null) {
                        mPresenter?.moreData(data)
                    }
                }
            }
        })

    }

    override fun onRefresh() {
        if (!mIsRefresh) {
            mIsRefresh = true
            mPresenter?.start()
        }
    }
}
package com.example.wankotlin.ui.fragment

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wankotlin.R
import com.example.wankotlin.adapter.CollectAdapter
import com.example.wankotlin.base.BaseMvpFragment
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.event.ColorEvent
import com.example.wankotlin.event.RefreshHomeEvent
import com.example.wankotlin.ext.showToast
import com.example.wankotlin.mvp.contract.CollectContract
import com.example.wankotlin.mvp.model.bean.CollectionArticle
import com.example.wankotlin.mvp.model.bean.CollectionResponseBody
import com.example.wankotlin.mvp.presenter.CollectPresenter
import com.example.wankotlin.ui.activity.ContentActivity
import com.example.wankotlin.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_collect.*
import kotlinx.android.synthetic.main.fragment_refresh_layout.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CollectFragment: BaseMvpFragment<CollectContract.View, CollectContract.Presenter>(), CollectContract.View {

    companion object {
        fun getInstance(bundle: Bundle): CollectFragment {
            val fragment = CollectFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun createPresenter(): CollectContract.Presenter = CollectPresenter()

    override fun useEventBus(): Boolean = true

    /**
     * datas
     */
    private val datas = mutableListOf<CollectionArticle>()

    /**
     * LinearLayoutManager
     */
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }

    /**
     * RecyclerView Divider
     */
    private val recyclerViewItemDecoration by lazy {
        activity?.let {
            SpaceItemDecoration(it)
        }
    }

    /**
     * Collect Adapter
     */
    private val collectAdapter: CollectAdapter by lazy {
        CollectAdapter(activity, datas = datas)
    }

    /**
     * is Refresh
     */
    private var isRefresh = true

    override fun showLoading() {
        // swipeRefreshLayout.isRefreshing = isRefresh
    }

    override fun hideLoading() {
        swipeRefreshLayout?.isRefreshing = false
        if (isRefresh) {
            collectAdapter.run { setEnableLoadMore(true) }
        }
    }

    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        mLayoutStatusView?.showError()
        collectAdapter.run {
            if (isRefresh)
                setEnableLoadMore(true)
            else
                loadMoreFail()
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_collect

    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        swipeRefreshLayout.run {
            setOnRefreshListener(onRefreshListener)
        }

        recyclerView.run {
            layoutManager = linearLayoutManager
            adapter = collectAdapter
            itemAnimator = DefaultItemAnimator()
            recyclerViewItemDecoration?.let { addItemDecoration(it) }
        }

        collectAdapter.run {
            bindToRecyclerView(recyclerView)
            setOnLoadMoreListener(onRequestLoadMoreListener, recyclerView)
            onItemClickListener = this@CollectFragment.onItemClickListener
            onItemChildClickListener = this@CollectFragment.onItemChildClickListener
            // setEmptyView(R.layout.fragment_empty_layout)
        }

        floating_action_btn.setOnClickListener {
            scrollToTop()
        }
    }

    override fun lazyLoad() {
        mLayoutStatusView?.showLoading()
        mPresenter?.getCollectList(0)
    }

    override fun showRemoveCollectSuccess(success: Boolean) {
        if (success) {
            showToast(getString(R.string.cancel_collect_success))
            EventBus.getDefault().post(RefreshHomeEvent(true))
        }
    }

    override fun setCollectList(articles: CollectionResponseBody<CollectionArticle>) {
        articles.datas.let {
            collectAdapter.run {
                if (isRefresh) {
                    replaceData(it)
                } else {
                    addData(it)
                }
                val size = it.size
                if (size < articles.size) {
                    loadMoreEnd(isRefresh)
                } else {
                    loadMoreComplete()
                }
            }
        }
        if (collectAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }
    }

    override fun scrollToTop() {
        recyclerView.run {
            if (linearLayoutManager.findFirstVisibleItemPosition() > 20) {
                scrollToPosition(0)
            } else {
                smoothScrollToPosition(0)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshColor(event: ColorEvent) {
        if (event.isRefresh) {
            floating_action_btn.backgroundTintList = ColorStateList.valueOf(event.color)
        }
    }

    /**
     * RefreshListener
     */
    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        isRefresh = true
        collectAdapter.setEnableLoadMore(false)
        mPresenter?.getCollectList(0)
    }
    /**
     * LoadMoreListener
     */
    private val onRequestLoadMoreListener = BaseQuickAdapter.RequestLoadMoreListener {
        isRefresh = false
        swipeRefreshLayout.isRefreshing = false
        val page = collectAdapter.data.size / 20
        mPresenter?.getCollectList(page)
    }

    /**
     * ItemClickListener
     */
    private val onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, _, position ->
        if (datas.size != 0) {
            val data = datas[position]
            Intent(activity, ContentActivity::class.java).run {
                putExtra(Constant.CONTENT_URL_KEY, data.link)
                putExtra(Constant.CONTENT_TITLE_KEY, data.title)
                putExtra(Constant.CONTENT_ID_KEY, data.id)
                startActivity(this)
            }
        }
    }

    /**
     * ItemChildClickListener
     */
    private val onItemChildClickListener =
        BaseQuickAdapter.OnItemChildClickListener { _, view, position ->
            if (datas.size != 0) {
                val data = datas[position]
                when (view.id) {
                    R.id.iv_like -> {
                        collectAdapter.remove(position)
                        mPresenter?.removeCollectArticle(data.id, data.originId)
                    }
                }
            }
        }

}
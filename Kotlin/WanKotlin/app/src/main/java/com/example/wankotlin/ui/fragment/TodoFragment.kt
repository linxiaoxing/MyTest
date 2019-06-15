package com.example.wankotlin.ui.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wankotlin.R
import com.example.wankotlin.adapter.TodoAdapter
import com.example.wankotlin.app.App
import com.example.wankotlin.base.BaseMvpFragment
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.event.RefreshTodoEvent
import com.example.wankotlin.event.TodoEvent
import com.example.wankotlin.event.TodoTypeEvent
import com.example.wankotlin.ext.showSnackMsg
import com.example.wankotlin.ext.showToast
import com.example.wankotlin.mvp.contract.TodoContract
import com.example.wankotlin.mvp.model.bean.TodoDataBean
import com.example.wankotlin.mvp.model.bean.TodoResponseBody
import com.example.wankotlin.mvp.presenter.TodoPresenter
import com.example.wankotlin.ui.activity.CommonActivity
import com.example.wankotlin.utils.DialogUtil
import com.example.wankotlin.utils.NetWorkUtil
import com.example.wankotlin.widget.SpaceItemDecoration
import com.example.wankotlin.widget.SwipeItemLayout
import kotlinx.android.synthetic.main.fragment_refresh_layout.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TodoFragment : BaseMvpFragment<TodoContract.View, TodoContract.Presenter>(), TodoContract.View {

    companion object {
        fun getInstance(type: Int): TodoFragment {
            val fragment = TodoFragment()
            val bundle = Bundle()
            bundle.putInt(Constant.TODO_TYPE, type)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun createPresenter(): TodoContract.Presenter = TodoPresenter()

    /**
     * is Refresh
     */
    private var isRefresh = true

    private var mType: Int = 0

    /**
     * 是否是已完成 false->待办 true->已完成
     */
    private var bDone: Boolean = false

    private val datas = mutableListOf<TodoDataBean>()

    private val mAdapter: TodoAdapter by lazy {
        TodoAdapter(R.layout.item_todo_list, R.layout.item_sticky_header, datas)
    }

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

    override fun hideLoading() {
        swipeRefreshLayout?.isRefreshing = false
        if (isRefresh) {
            mAdapter.run {
                setEnableLoadMore(true)
            }
        }
    }

    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        mLayoutStatusView?.showError()
        mAdapter.run {
            if (isRefresh)
                setEnableLoadMore(true)
            else
                loadMoreFail()
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_todo

    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        mType = arguments?.getInt(Constant.TODO_TYPE) ?: 0

        swipeRefreshLayout.run {
            setOnRefreshListener(onRefreshListener)
        }

        recyclerView.run {
            layoutManager = linearLayoutManager
            adapter = mAdapter
            itemAnimator = DefaultItemAnimator()
            recyclerViewItemDecoration?.let { addItemDecoration(it) }
            addOnItemTouchListener(SwipeItemLayout.OnSwipeItemTouchListener(activity))
        }

        mAdapter.run {
            bindToRecyclerView(recyclerView)
            setOnLoadMoreListener(onRequestLoadMoreListener, recyclerView)
            onItemClickListener = this@TodoFragment.onItemClickListener
            onItemChildClickListener = this@TodoFragment.onItemChildClickListener
        }

    }

    override fun lazyLoad() {
        mLayoutStatusView?.showLoading()
        if (bDone) {
            mPresenter?.getDoneList(1, mType)
        } else {
            mPresenter?.getNoTodoList(1, mType)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun doTodoTypeEvent(event: TodoTypeEvent) {
        mType = event.type
        bDone = false
        lazyLoad()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun doTodoEvent(event: TodoEvent) {
        if (mType == event.curIndex) {
            when (event.type) {
                Constant.TODO_ADD -> {
                    Intent(activity, CommonActivity::class.java).run {
                        putExtra(Constant.TYPE_KEY, Constant.Type.ADD_TODO_TYPE_KEY)
                        putExtra(Constant.TODO_TYPE, mType)
                        startActivity(this)
                    }
                }
                Constant.TODO_NO -> {
                    bDone = false
                    lazyLoad()
                }
                Constant.TODO_DONE -> {
                    bDone = true
                    lazyLoad()
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun doRefresh(event: RefreshTodoEvent) {
        if (event.isRefresh) {
            if (mType == event.type) {
                lazyLoad()
            }
        }
    }

    override fun showNoTodoList(todoResponseBody: TodoResponseBody) {
        // TODO 待优化
        val list = mutableListOf<TodoDataBean>()
        var bHeader = true
        todoResponseBody.datas.forEach { todoBean ->
            bHeader = true
            for (i in list.indices) {
                if (todoBean.dateStr == list[i].header) {
                    bHeader = false
                    break
                }
            }
            if (bHeader)
                list.add(TodoDataBean(true, todoBean.dateStr))
            list.add(TodoDataBean(todoBean))
        }

        list.let {
            mAdapter.run {
                if (isRefresh) {
                    replaceData(it)
                } else {
                    addData(it)
                }
                val size = it.size
                if (size < todoResponseBody.size) {
                    loadMoreEnd(isRefresh)
                } else {
                    loadMoreComplete()
                }
            }
        }
        if (mAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }
    }

    override fun showDeleteSuccess(success: Boolean) {
        if (success) {
            showToast(resources.getString(R.string.delete_success))
        }
    }

    override fun showUpdateSuccess(success: Boolean) {
        if (success) {
            showToast(resources.getString(R.string.completed))
        }
    }

    /**
     * RefreshListener
     */
    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        isRefresh = true
        mAdapter.setEnableLoadMore(false)
        lazyLoad()
    }

    /**
     * LoadMoreListener
     */
    private val onRequestLoadMoreListener = BaseQuickAdapter.RequestLoadMoreListener {
        isRefresh = false
        swipeRefreshLayout.isRefreshing = false
        val page = mAdapter.data.size / 20 + 1
        if (bDone) {
            mPresenter?.getDoneList(page, mType)
        } else {
            mPresenter?.getNoTodoList(page, mType)
        }
    }

    /**
     * ItemClickListener
     */
    private val onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, _, position ->
        if (datas.size != 0) {
            val data = datas[position]
        }
    }

    /**
     * ItemChildClickListener
     */
    private val onItemChildClickListener =
        BaseQuickAdapter.OnItemChildClickListener { _, view, position ->
            if (datas.size != 0) {
                val data = datas[position].t
                when (view.id) {
                    R.id.btn_delete -> {
                        if (!NetWorkUtil.isNetworkAvailable(App.context)) {
                            showSnackMsg(resources.getString(R.string.no_network))
                            return@OnItemChildClickListener
                        }
                        activity?.let {
                            DialogUtil.getConfirmDialog(it, resources.getString(R.string.confirm_delete),
                                DialogInterface.OnClickListener { _, _ ->
                                    mPresenter?.deleteTodoById(data.id)
                                    mAdapter.remove(position)
                                }).show()
                        }
                    }
                    R.id.btn_done -> {
                        if (!NetWorkUtil.isNetworkAvailable(App.context)) {
                            showSnackMsg(resources.getString(R.string.no_network))
                            return@OnItemChildClickListener
                        }
                        if (bDone) {
                            mPresenter?.updateTodoById(data.id, 0)
                        } else {
                            mPresenter?.updateTodoById(data.id, 1)
                        }
                        mAdapter.remove(position)
                    }
                    R.id.item_todo_content -> {
                        if (bDone) {
                            Intent(activity, CommonActivity::class.java).run {
                                putExtra(Constant.TYPE_KEY, Constant.Type.SEE_TODO_TYPE_KEY)
                                putExtra(Constant.TODO_BEAN, data)
                                putExtra(Constant.TODO_TYPE, mType)
                                startActivity(this)
                            }
                        } else {
                            Intent(activity, CommonActivity::class.java).run {
                                putExtra(Constant.TYPE_KEY, Constant.Type.EDIT_TODO_TYPE_KEY)
                                putExtra(Constant.TODO_BEAN, data)
                                putExtra(Constant.TODO_TYPE, mType)
                                startActivity(this)
                            }
                        }
                    }
                }
            }
        }

}
package com.example.bilibilikotlin.module.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.home.live.LiveAdapter
import com.example.bilibilikotlin.base.BaseRefreshFragment
import com.example.bilibilikotlin.bean.live.MulLive
import com.example.bilibilikotlin.mvp.contract.home.LiveContract
import com.example.bilibilikotlin.mvp.presenter.live.LivePresenter

class LiveFragment : BaseRefreshFragment<LivePresenter, MulLive>(), LiveContract.View {

    private var mAdapter: LiveAdapter? = null

    override fun getLayoutId(): Int = R.layout.fragment_home_live

    companion object {
        fun newInstance(): LiveFragment {
            return LiveFragment()
        }
    }

    override fun lazyLoadData() {
        mPresenter.getLiveData()
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initRecyclerView() {
        mAdapter = LiveAdapter(mList)
        mRecycler?.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(activity)
        mRecycler?.layoutManager = mLayoutManager
        mRecycler?.adapter = mAdapter

    }


    override fun finishTask() {
        mAdapter?.notifyDataSetChanged()
    }

    override fun showMulLive(mulLives: List<MulLive>) {
        mList.addAll(mulLives)
        finishTask()
    }
}
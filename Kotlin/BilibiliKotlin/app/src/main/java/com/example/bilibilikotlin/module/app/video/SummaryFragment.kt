package com.example.bilibilikotlin.module.app.video

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.app.video.SummaryAdapter
import com.example.bilibilikotlin.base.BaseInjectFragment
import com.example.bilibilikotlin.bean.app.video.MulSummary
import com.example.bilibilikotlin.mvp.contract.app.video.SummaryContract
import com.example.bilibilikotlin.mvp.presenter.app.video.SummaryPresenter

import kotlinx.android.synthetic.main.common_recycler.*

class SummaryFragment : BaseInjectFragment<SummaryPresenter>(), SummaryContract.View {

    private val mList = mutableListOf<MulSummary>()
    private var mAdapter: SummaryAdapter? = null

    override fun getLayoutId(): Int = R.layout.fragment_summary

    override fun loadData() {
        mPresenter.getSummaryData()
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initRecyclerView() {
        mAdapter = SummaryAdapter(mList)
        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(mContext)
        recycler.layoutManager = layoutManager
        recycler.adapter = mAdapter
    }

    override fun finishTask() {
        mAdapter?.notifyDataSetChanged()
    }

    override fun showSummary(mulSummaries: List<MulSummary>) {
        mList.addAll(mulSummaries)
        finishTask()
    }


    override fun initWidget() {
        initRecyclerView()
    }

    companion object {

        fun newInstance(): SummaryFragment {
            return SummaryFragment()
        }
    }
}
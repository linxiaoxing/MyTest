package com.example.waneye.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.waneye.R
import com.example.waneye.adapter.RankAdapter
import com.example.waneye.mvp.contract.HotContract
import com.example.waneye.mvp.model.bean.HotBean
import com.example.waneye.mvp.presenter.HomePresenter
import com.example.waneye.mvp.presenter.HotPresenter
import kotlinx.android.synthetic.main.rank_fragment.*


class RankFragment: BaseFragment(), HotContract.View {

    private lateinit var mPresenter: HotPresenter
    private lateinit var mStrategy: String
    private lateinit var mAdapter: RankAdapter
    var mList: ArrayList<HotBean.ItemListBean.DataBean> = ArrayList()
    override fun getLayoutResources(): Int {
        return R.layout.rank_fragment
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = RankAdapter(context!!, mList)
        recyclerView.adapter = mAdapter
        if (arguments != null) {
            mStrategy = arguments!!.getString("strategy")
            mPresenter = HotPresenter(context!!, this)
            mPresenter.requestData(mStrategy)
        }
    }

    override fun setData(bean: HotBean) {
        Log.e("rank", bean.toString())
        if (mList.size > 0) {
            mList.clear()
        }
        bean.itemList?.forEach {
            it.data?.let { it1 -> mList.add(it1) }
        }
        mAdapter.notifyDataSetChanged()
    }
}
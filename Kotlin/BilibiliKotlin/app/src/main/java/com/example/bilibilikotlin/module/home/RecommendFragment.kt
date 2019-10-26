package com.example.bilibilikotlin.module.home

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.home.RecommendAdapter
import com.example.bilibilikotlin.base.BaseRefreshFragment
import com.example.bilibilikotlin.bean.recommend.MulRecommend
import com.example.bilibilikotlin.bean.recommend.Recommend
import com.example.bilibilikotlin.mvp.contract.home.RecommendContract
import com.example.bilibilikotlin.mvp.presenter.RecommendPresenter
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.widget.divider.VerticalDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_home_recommend.*

class RecommendFragment : BaseRefreshFragment<RecommendPresenter, MulRecommend>(), RecommendContract.View {

    private var mAdapter: RecommendAdapter? = null

    override fun getLayoutId(): Int = R.layout.fragment_home_recommend


    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun lazyLoadData() {
        mPresenter.getRecommendData()
    }

    override fun initWidget() {
        super.initWidget()
        //ivRank?.setOnClickListener { startActivity(Intent(activity, AllStationRankActivity::class.java)) }
    }

    override fun initRecyclerView() {
        mAdapter = RecommendAdapter(mList)
        val mLayoutManager = GridLayoutManager(activity, 2)
        mAdapter?.setSpanSizeLookup({ _, i -> mList[i].spanSize })
        mRecycler?.layoutManager = mLayoutManager
        mRecycler?.adapter = mAdapter
        //添加分割条
        val build = VerticalDividerItemDecoration.Builder(activity)
            .color(AppUtils.getColor(R.color.transparent))
            // .color(AppUtils.getColor(R.color.colorPrimary))
            .sizeResId(R.dimen.dp10)
            .showLastDivider()
            .build()
        mRecycler?.addItemDecoration(build)
    }

    override fun showRecommend(recommend: List<Recommend>) {
        recommend.forEach {
            if (it.banner_item != null && it.banner_item.isNotEmpty()) {
                mList.add(MulRecommend(itemTypez = MulRecommend.TYPE_HEADER, spanSize = MulRecommend.HEADER_SPAN_SIZE, data = it.banner_item))
            } else {
                mList.add(MulRecommend(itemTypez = MulRecommend.TYPE_ITEM, spanSize = MulRecommend.ITEM_SPAN_SIZE, recommend = it))
            }

        }
        finishTask()
    }

    override fun finishTask() {
        mAdapter?.notifyDataSetChanged()
    }

    companion object {

        fun newInstance(): RecommendFragment = RecommendFragment()

    }

}
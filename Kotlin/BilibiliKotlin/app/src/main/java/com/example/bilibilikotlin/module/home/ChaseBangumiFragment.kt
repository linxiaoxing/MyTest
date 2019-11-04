package com.example.bilibilikotlin.module.home

import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.home.section.ChaseAdSection
import com.example.bilibilikotlin.adapter.home.section.ChaseFollowSection
import com.example.bilibilikotlin.adapter.home.section.ChaseIndexSection
import com.example.bilibilikotlin.base.BaseRefreshFragment
import com.example.bilibilikotlin.bean.chase.ChaseBangumi
import com.example.bilibilikotlin.bean.chase.RecommendBangumi
import com.example.bilibilikotlin.mvp.contract.home.ChaseBangumiContract
import com.example.bilibilikotlin.mvp.presenter.home.ChaseBangumiPresenter
import com.example.bilibilikotlin.widget.section.SectionedRVAdapter

class ChaseBangumiFragment : BaseRefreshFragment<ChaseBangumiPresenter, ChaseBangumi.Follows>(), ChaseBangumiContract.View {

    private var mSectionedAdapter: SectionedRVAdapter? = null
    @Volatile private var mChaseBangumi: ChaseBangumi? = null
    private var mRecommendCnBean: RecommendBangumi.RecommendCn? = null
    private var mRecommendJpBean: RecommendBangumi.RecommendJp? = null
    private var mRecommendBangumi: RecommendBangumi? = null

    companion object {

        fun newInstance(): ChaseBangumiFragment {
            return ChaseBangumiFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_home_chase_bangumi

    override fun clear() {
        mSectionedAdapter?.removeAllSections()
    }

    override fun lazyLoadData() {
        mPresenter.getChaseBangumiData()
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun showChaseBangumi(chaseBangumi: ChaseBangumi) {
        mChaseBangumi = chaseBangumi
    }

    override fun showRecommendBangumi(recommendBangumi: RecommendBangumi) {
        mChaseBangumi?.follows?.let { mList.addAll(it) }
        mRecommendBangumi = recommendBangumi
        mRecommendCnBean = recommendBangumi.recommend_cn
        mRecommendJpBean = recommendBangumi.recommend_jp
        finishTask()
    }


    override fun finishTask() {
        mSectionedAdapter?.addSection(ChaseIndexSection())
        mSectionedAdapter?.addSection(ChaseFollowSection("${mChaseBangumi?.update_count}", mList))
        mRecommendBangumi?.ad?.let {
            if (it.isNotEmpty()) {
                mSectionedAdapter?.addSection(ChaseAdSection(it[0]))
            }
        }
        mSectionedAdapter?.addSection(mRecommendJpBean?.recommend?.let { mRecommendJpBean?.foot?.get(0)?.let { it1 -> ChaseRecommendJPSection(it, it1) } })
        mSectionedAdapter?.addSection(mRecommendCnBean?.recommend?.let { mRecommendCnBean?.foot?.get(0)?.let { it1 -> ChaseRecommendCNSection(it, it1) } })
        mSectionedAdapter?.notifyDataSetChanged()
    }

}
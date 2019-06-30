package com.example.wanandroidmvvm.ui.home

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.base.BaseFragment
import com.example.wanandroidmvvm.R
import com.example.wanandroidmvvm.adapter.HomeArticleAdapter
import com.example.wanandroidmvvm.dp2px
import com.example.wanandroidmvvm.model.bean.ArticleList
import com.example.wanandroidmvvm.model.bean.Banner
import com.example.wanandroidmvvm.util.GlideImageLoader
import com.example.wanandroidmvvm.util.Preference
import com.example.wanandroidmvvm.view.SpaceItemDecoration
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment<HomeViewModel>() {


    override fun providerVMClass(): Class<HomeViewModel>? = HomeViewModel::class.java
    private val isLogin by Preference(Preference.IS_LOGIN, false)
    private val homeArticleAdapter by lazy { HomeArticleAdapter() }
    private var bannerImages = mutableListOf<String>()
    private var bannerTitles = mutableListOf<String>()
    private var bannerUrls = mutableListOf<String>()

    private var currentPage = 0
    private val banner by lazy { com.youth.banner.Banner(activity) }

    override fun getLayoutResId() = R.layout.fragment_home

    override fun initView() {
         homeRecycleView.run {
             layoutManager = LinearLayoutManager(activity)
             addItemDecoration(SpaceItemDecoration(homeRecycleView.dp2px(10f)))
         }

        initBanner()
        initAdapter()

        homeRefreshLayout.run {
            setOnRefreshListener { refresh() }
            isRefreshing = true
        }
        refresh()
    }

    private fun initBanner() {
        banner.run {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, banner.dp2px(200f))
            setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
            setImageLoader(GlideImageLoader())
            setOnBannerListener { position ->
                run {
//                    val intent = Intent(activity, BrowserNormalActivity::class.java)
//                    intent.putExtra(BrowserNormalActivity.URL, bannerUrls[position])
//                    startActivity(intent)
                }
            }
        }
    }

    private fun initAdapter() {
        homeArticleAdapter.run {
            setOnItemClickListener { _, _, position ->
//                Intent(activity, BrowserNormalActivity::class.java).run {
//                    putExtra(BrowserNormalActivity.URL, homeArticleAdapter.data[position].link)
//                    startActivity(this)
//                }
            }

            onItemChildClickListener = this@HomeFragment.onItemChildClickListener
        }
    }

    private val onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { _, view, position ->
        when (view.id) {
            R.id.articleStar -> {
//                if (isLogin) {
//                    homeArticleAdapter.run {
//                        data[position].run {
//                            collect = !collect
//                            mViewModel.collectArticle(id, collect)
//                        }
//                        notifyDataSetChanged()
//                    }
//                } else {
//                    Intent(activity, LoginActivity::class.java).run { startActivity(this) }
//                }
            }
        }
    }

    private fun loadMore() {
        mViewModel.getArticleList(currentPage)
    }

    override fun initData() {
        mViewModel.getBanners()
    }

    private fun refresh() {
        homeArticleAdapter.setEnableLoadMore(false)
        homeRefreshLayout.isRefreshing = true
        currentPage = 0
        mViewModel.getArticleList(currentPage)
    }

    override fun startObserve() {
        mViewModel.apply {
            mBanners.observe(this@HomeFragment, Observer {it ->
                it?.let { setBanner(it) }
            })
            mArticleList.observe(this@HomeFragment, Observer { it ->
                it?.let { setArticles(it) }
            })
        }
    }

    private fun setArticles(articleList: ArticleList) {
        homeArticleAdapter.run {
            if (homeRefreshLayout.isRefreshing) replaceData(articleList.datas)
            else addData(articleList.datas)
            setEnableLoadMore(true)
            loadMoreComplete()
        }
        homeRefreshLayout.isRefreshing = false
        currentPage++
    }

    private fun setBanner(bannerList: List<Banner>) {
        for (banner in bannerList) {
            bannerImages.add(banner.imagePath)
            bannerTitles.add(banner.title)
            bannerUrls.add(banner.url)
        }
        banner.setImages(bannerImages)
            .setBannerTitles(bannerTitles)
            .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
            .setDelayTime(3000)
        banner.start()
    }

    override fun onStart() {
        super.onStart()
        banner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        banner.stopAutoPlay()
    }
}
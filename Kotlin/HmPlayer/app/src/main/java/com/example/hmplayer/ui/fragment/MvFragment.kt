package com.example.hmplayer.ui.fragment

import android.view.View
import android.view.View.inflate
import com.example.hmplayer.R
import com.example.hmplayer.adapter.MvPagerAdapter
import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.MvAreaBean
import com.example.hmplayer.presenter.impl.MvPresenterImpl
import com.example.hmplayer.view.MvView
import kotlinx.android.synthetic.main.fragment_mv.*

class MvFragment: BaseFragment(), MvView {

    val mvPresenter by lazy { MvPresenterImpl(this, this) }
    override fun initView(): View? {
        return inflate(context, R.layout.fragment_mv, null)
    }

    override fun initListener() {

    }

    override fun initData() {
      mvPresenter.loadData()
    }

    override fun onError(msg: String?) {

    }

    override fun onSuccess(result: List<MvAreaBean>?) {
        // 在fragment中管理fragment需要用childFragment，不是getFragmentManager
        val adapter = MvPagerAdapter(result, childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
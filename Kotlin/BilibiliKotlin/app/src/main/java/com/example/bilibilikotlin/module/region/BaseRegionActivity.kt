package com.example.bilibilikotlin.module.region

import android.annotation.SuppressLint
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.base.BaseInjectActivity
import com.flyco.tablayout.SlidingTabLayout

abstract class BaseRegionActivity<T : BaseContract.BasePresenter<*>, K> : BaseInjectActivity<T>() {

    protected var mTvTitle: TextView? = null
    protected var mIvBack: ImageView? = null
    protected var mList = mutableListOf<K>()
    protected var mTitles = mutableListOf<String>()
    protected var mFragment = mutableListOf<Fragment>()

    protected var mSlidingTabLayout: SlidingTabLayout? = null

    var mViewPager: ViewPager? = null

    @SuppressLint("CheckResult")
    override fun initToolbar() {
        mTvTitle = findViewById(R.id.tv_title) as TextView?
        mIvBack = findViewById(R.id.iv_back) as ImageView?
        mIvBack?.setOnClickListener { finish() }
    }

    protected fun setTitle(title: String) {
        mTvTitle?.text = title
    }

    override fun initWidget() {
        super.initWidget()
        initSlidingTabLayout()
    }

    protected fun initSlidingTabLayout() {
        mSlidingTabLayout = findViewById(R.id.sliding_tabs) as SlidingTabLayout?
        mViewPager = findViewById(R.id.view_pager) as ViewPager?

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_region, menu)
        return true
    }

    protected open fun initFragment() {}

    protected open fun initTitle() {}

    override fun finishTask() {
        initTitle()
        initFragment()
        initViewPager()
        initEvent()
    }

    protected open fun initViewPager() {
        mViewPager?.offscreenPageLimit = mTitles.size
        mViewPager?.adapter = BaseRegionTypeAdapter(supportFragmentManager)
        mSlidingTabLayout?.setViewPager(mViewPager)
    }

    /**
     * 初始化事件
     */
    protected open fun initEvent() {

    }

    protected fun setCurrentItem(pos: Int) {
        mViewPager?.currentItem = pos
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {

        }

        return super.onOptionsItemSelected(item)
    }

    inner class BaseRegionTypeAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            mFragment.let {
                return it[position]
            }
        }

        override fun getCount(): Int = mTitles.size


        override fun getPageTitle(position: Int): CharSequence = mTitles[position]

    }

}
package com.example.wankotlin.ui.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.support.design.widget.TabLayout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.wankotlin.R
import com.example.wankotlin.adapter.KnowledgePagerAdapter
import com.example.wankotlin.base.BaseMvpSwipeBackActivity
import com.example.wankotlin.base.BaseSwipeBackActivity
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.event.ColorEvent
import com.example.wankotlin.mvp.model.bean.Knowledge
import com.example.wankotlin.mvp.model.bean.KnowledgeTreeBody
import com.example.wankotlin.ui.fragment.KnowledgeFragment
import com.example.wankotlin.utils.SettingUtil
import kotlinx.android.synthetic.main.activity_knowledge.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.view

class KnowledgeActivity: BaseSwipeBackActivity() {

    /**
     * datas
     */
    private var knowledges = mutableListOf<Knowledge>()

    /**
     * toolbar title
     */
    private lateinit var toolbarTitle: String

    /**
     * ViewPagerAdapter
     */
    private val viewPagerAdapter: KnowledgePagerAdapter by lazy {
        KnowledgePagerAdapter(knowledges, supportFragmentManager)
    }

    override fun attachLayoutRes(): Int = R.layout.activity_knowledge

    override fun initData() {

        intent.extras?.let {
            toolbarTitle = it.getString(Constant.CONTENT_TITLE_KEY) ?: ""
            it.getSerializable(Constant.CONTENT_DATA_KEY)?.let {
                val data = it as KnowledgeTreeBody
                data.children.let {
                        children ->
                    knowledges.addAll(children)
                }
            }
        }
    }

    override fun useEventBus(): Boolean = true

    override fun initView() {
        toolbar.run {
            title = toolbarTitle
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        viewPager.run {
            adapter = viewPagerAdapter
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
            offscreenPageLimit = knowledges.size
        }

        tabLayout.run {
            setupWithViewPager(viewPager)
            addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
            addOnTabSelectedListener(onTabSelectedListener)
        }

        floating_action_btn.run {
            setOnClickListener(onFABClickListener)
        }
    }

    override fun start() {
    }

    override fun initColor() {
        super.initColor()
        refreshColor(ColorEvent(true))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshColor(event: ColorEvent) {
        if (event.isRefresh) {
            if (!SettingUtil.getIsNightMode()) {
                tabLayout.setBackgroundColor(SettingUtil.getColor())
                floating_action_btn.backgroundTintList = ColorStateList.valueOf(mThemeColor)
            }
        }
    }

    /**
     * onTabSelectedListener
     */
    private val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
        }

        override fun onTabSelected(tab: TabLayout.Tab?) {
            // 默认切换的时候，会有一个过渡动画，设为false后，取消动画，直接显示
            tab?.let {
                viewPager.setCurrentItem(it.position, false)
            }
        }
    }

    /**
     * FAB 监听
     */
    private val onFABClickListener = View.OnClickListener {
        if (viewPagerAdapter.count == 0) {
            return@OnClickListener
        }
        val fragment: KnowledgeFragment = viewPagerAdapter.getItem(viewPager.currentItem) as KnowledgeFragment
        fragment.scrollToTop()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_type_content, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {

            R.id.action_share -> {
                Intent().run {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,
                        getString(
                            R.string.share_article_url,
                            getString(R.string.app_name),
                            knowledges[tabLayout.selectedTabPosition].name,
                            knowledges[tabLayout.selectedTabPosition].id.toString()
                        ))
                    type = Constant.CONTENT_SHARE_TYPE
                    startActivity(Intent.createChooser(this, getString(R.string.action_share)))
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.bilibilikotlin.module.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.home.MainAdapter
import com.example.bilibilikotlin.event.Event
import com.example.bilibilikotlin.rx.RxBus
import kotlinx.android.synthetic.main.layout_main_toolbar.*

class HomeFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_home
    }

    override fun initWidget() {
        super.initWidget()
        initViewPager()
        llNavigation.setOnClickListener {
            val event = Event.StartNavigationEvent()
            event.start = true
            RxBus.post(event)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater?.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
//        when (id) {
//            R.id.menu_game -> startActivity(Intent(mContext, GameCenterActivity::class.java))
//        }

        return super.onOptionsItemSelected(item)
    }


    private fun initViewPager() {
        val adapter = MainAdapter(childFragmentManager)
        viewPager.offscreenPageLimit = 5
        viewPager.adapter = adapter
        stlTabs.setViewPager(viewPager)
        viewPager.currentItem = 0

    }
}
package com.example.musicplayersam.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.activity.base.BaseActivity
import com.example.musicplayersam.ui.fragment.home.MainCloudFragment
import com.example.musicplayersam.ui.fragment.home.MainMusicFragment
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.support.attrValue
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_app_main.*
import kotlinx.android.synthetic.main.main_content.*

/**
 * the main activity of application
 */
@LayoutId(R.layout.activity_app_main)
class AppMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.open_navigation_drawer, R.string.close_navigation_drawer)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = attrValue(R.attr.quietTextPrimaryInverse)
        drawerToggle.syncState()

        pagerMain.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(pagerMain))
        pagerMain.adapter = MainPagerAdapter()

        //inflate menu to toolbar, only has ONE option which is SEARCH
        toolbar.inflateMenu(R.menu.menu_app_main)

        listenBottomControllerEvent()
    }

    inner class MainPagerAdapter: FragmentPagerAdapter(supportFragmentManager) {

        private val _fragments = Array<Fragment?>(2) { null }

        override fun getItem(position: Int): Fragment {
            if (_fragments[position] == null) {
                _fragments[position] = when (position) {
                    0 -> MainCloudFragment()
                    1 -> MainMusicFragment()
                    else -> error("can not create page for MainPager , position : $position")
                }

            }
            return _fragments[position]!!
        }

        override fun getCount(): Int {
            return 2
        }
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
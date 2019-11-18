package com.example.musicplayersam.ui.activity.local

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.activity.base.BaseActivity
import com.example.musicplayersam.ui.fragment.local.LocalAlbumFragment
import com.example.musicplayersam.ui.fragment.local.LocalArtistFragment
import com.example.musicplayersam.ui.fragment.local.LocalSingleSongFragment
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import kotlinx.android.synthetic.main.activity_local_music.*

/**
 * local music main activity
 *
 * contain three fragment [LocalAlbumFragment] [LocalSingleSongFragment] [LocalArtistFragment]
 */
@LayoutId(R.layout.activity_local_music)
@EnableBottomController
class LocalMusicActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = LocalPagerAdapter()
        //init toolbar
        toolbar.inflateMenu(R.menu.menu_local_home_page)
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.menu_local_home_scan) {
                startActivity(Intent(this, LocalScannerActivity::class.java))
            }
            true
        }
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private inner class LocalPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {
        private val fragments = Array<Fragment?>(count) { null }

        override fun getItem(position: Int): Fragment = fragments[position] ?: when (position) {
                0 -> LocalSingleSongFragment()
                1 -> LocalArtistFragment()
                2 -> LocalAlbumFragment()
                else -> error("illegal position $position")
            }.also {
                fragments[position] = it
            }

        override fun getPageTitle(position: Int) = when (position) {
            0 -> AppContext.getString(R.string.single_song)
            1 -> AppContext.getString(R.string.artist)
            2 -> AppContext.getString(R.string.album)
            else -> null
        }

        override fun getCount(): Int = 3
    }
}
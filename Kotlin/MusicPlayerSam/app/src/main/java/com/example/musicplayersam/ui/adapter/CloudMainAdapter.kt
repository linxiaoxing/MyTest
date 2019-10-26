package com.example.musicplayersam.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.R
import me.drakeet.multitype.MultiTypeAdapter

class CloudMainAdapter : MultiTypeAdapter() {

    companion object {

        const val SPAN_COUNT = 3

        private val NAVIGATORS = listOf(
            ItemNavigator(R.string.nav_radio, R.drawable.ic_radio_black_24dp),
            ItemNavigator(R.string.nav_daily_recommend, R.drawable.ic_today_black_24dp),
            ItemNavigator(R.string.nav_tends, R.drawable.ic_show_chart_black_24dp)
        )

        private val HEADER_RECOMMEND_PLAYLIST = ItemHeader(R.string.recommend_playlists)

        private val HEADER_NEW_SONGS = ItemHeader(R.string.new_songs)


        private const val TOKEN_NEW_SONGS = "cloud_new_songs-f"

    }

    private var recyclerView: RecyclerView? = null

    private val itemMusicBinder: ItemMusicBinder

}
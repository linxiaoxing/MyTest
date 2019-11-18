package com.example.musicplayersam.ui.activity.cloud

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicplayersam.R
import com.example.musicplayersam.repository.netease.NeteaseRepository
import com.example.musicplayersam.ui.activity.base.BaseListActivity
import com.example.musicplayersam.ui.activity.cloud.adapter.TopDetailListAdapter
import com.example.musicplayersam.ui.activity.cloud.adapter.TopDetailListAdapter.Companion.INDEX_GLOBAL
import com.example.musicplayersam.ui.activity.cloud.adapter.TopDetailListAdapter.Companion.INDEX_OFFICIAL
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.component.log
import kotlinx.android.synthetic.main.activity_base_list.*
import kotlinx.coroutines.launch

/**
 * 各个排行榜数据
 */
@EnableBottomController
class TopDetailActivity : BaseListActivity() {

    private val neteaseRepository by lazy { NeteaseRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setTitle(R.string.leader_board)

        val gridLayoutManager = GridLayoutManager(this, 3)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {

            override fun getSpanSize(position: Int): Int {
                return if (position in INDEX_OFFICIAL..INDEX_GLOBAL) 3 else 1
            }

        }
        recyclerView.layoutManager = gridLayoutManager
        loadData()
    }

    private fun loadData() {
        setLoading()
        launch {
            try {
                val detail = neteaseRepository.toplistDetail()
                recyclerView.adapter = TopDetailListAdapter(detail)
                setSuccess()
            } catch (e: Exception) {
                log { e.printStackTrace();"error" }
                setFailed()
            }
        }
    }

    override fun onRetryButtonClicked() {
        super.onRetryButtonClicked()
        loadData()
    }

}
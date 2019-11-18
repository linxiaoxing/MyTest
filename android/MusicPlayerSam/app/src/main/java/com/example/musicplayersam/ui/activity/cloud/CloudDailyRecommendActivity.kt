package com.example.musicplayersam.ui.activity.cloud

import android.os.Bundle
import com.example.musicplayersam.R
import com.example.musicplayersam.repository.netease.NeteaseRepository
import com.example.musicplayersam.ui.activity.base.BaseActivity
import com.example.musicplayersam.ui.activity.cloud.adapter.DailyRecommendAdapter
import com.example.musicplayersam.ui.adapter.MusicListAdapter
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.exception.NotLoginException
import com.example.musicplayersam.utils.setEmpty
import com.example.musicplayersam.utils.setLoading
import kotlinx.android.synthetic.main.activity_cloud_daily_recommend.*
import kotlinx.coroutines.launch

/**
 * 每日推荐歌曲activity
 */
@LayoutId(R.layout.activity_cloud_daily_recommend)
@EnableBottomController
class CloudDailyRecommendActivity : BaseActivity() {

    private val neteaseRepository by lazy { NeteaseRepository() }

    private lateinit var adapter: MusicListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = DailyRecommendAdapter()
        recyclerView.adapter = adapter

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        launch {
//            val user = neteaseRepository.getLoginUser()
//            if (user == null) {
//                log { "未登录" }
//                return@launch
//            }
            //adapter.setLoading()

            val list = try {
                neteaseRepository.recommendSongs()
            } catch (notLogin: NotLoginException) {
                //需要登录
                return@launch
            } catch (e: Exception) {
                e.printStackTrace()
                return@launch
            }

            if (list.isEmpty()) {
                adapter.setEmpty()
            } else {
                adapter.showList(list, false, false)
            }

        }

    }
}
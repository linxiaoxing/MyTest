package com.example.musicplayersam.ui.activity.cloud

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.EdgeEffect
import androidx.core.view.doOnLayout
import androidx.core.view.updatePadding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.R
import com.example.musicplayersam.player.MusicPlayerManager
import com.example.musicplayersam.ui.activity.base.BaseActivity
import com.example.musicplayersam.ui.activity.cloud.viewmodel.CloudPlayListDetailViewModel
import com.example.musicplayersam.ui.adapter.MusicListAdapter2
import com.example.musicplayersam.ui.adapter.viewholder.WindowInsetsEvent
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.support.attrValue
import com.example.musicplayersam.utils.component.support.dimen
import com.example.musicplayersam.utils.component.support.string
import com.example.musicplayersam.utils.event.PrimaryColorEvent
import kotlinx.android.synthetic.main.activity_cloud_play_list_detail.*
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import tech.soit.quiet.model.vo.PlayListDetail

@LayoutId(R.layout.activity_cloud_play_list_detail)
@EnableBottomController
class CloudPlayListDetailActivity : BaseActivity() {

    companion object {

        const val PARAM_ID = "id"

        const val PARAM_PLAY_LIST: String = "play_list"

    }

    private val viewModel by lazy { CloudPlayListDetailViewModel() }

    private lateinit var adapter: MusicListAdapter2

    private var playListTitle: String = string(R.string.title_play_list)

    /**
     * toolbar 背景色，需要随着歌单封面的不同而换成相应的颜色
     */
    private lateinit var toolbarBackground: ColorDrawable

    /**
     * 标题栏高度
     */
    private var headerHeight = (dimen(R.dimen.height_playlist_detail_cover) +
            dimen(R.dimen.height_playlist_detail_nav)).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        layoutRoot.setOnApplyWindowInsetsListener { _, insets ->
            if (insets.systemWindowInsetTop != 0) {
                toolbar.updatePadding(top = insets.systemWindowInsetTop)
                EventBus.getDefault().post(WindowInsetsEvent(insets))
            }
            return@setOnApplyWindowInsetsListener insets.consumeSystemWindowInsets()
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        toolbarBackground = ColorDrawable(attrValue(R.attr.colorPrimary))
        toolbar.background = toolbarBackground
        toolbar.bringToFront()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            private var offset: Int = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                offset += dy

                onHeaderOffset(offset)
            }

            fun onHeaderOffset(offset: Int) {
                val alpha = offset / headerHeight.toFloat()

                val title = if (alpha > 0.5) {
                    playListTitle
                } else {
                    string(R.string.title_play_list)
                }
                if (toolbar.title != title) {
                    toolbar.title = title
                }
                toolbarBackground.alpha = (alpha.coerceIn(0F, 1F) * 255).toInt()
            }

        })

        adapter = MusicListAdapter2()
        recyclerView.adapter = adapter

        layoutRoot.doOnLayout {
            adapter.placeholderHeight = it.height -
                    /*标题高度*/
                    (headerHeight + toolbar.height + dimen(R.dimen.height_header_music_list).toInt())
        }

        //预览
        val playlist = intent.getSerializableExtra(PARAM_PLAY_LIST) as? PlayListDetail
        if (playlist != null) {
            playListTitle = playlist.getName()
            adapter.showList(viewModel.getLoginUser(), playlist)
        }

        val playlistId = intent.getLongExtra(PARAM_ID, -1)
        if (playlistId == -1L) {
            error("need playlist id")
        }

        launch {
            val detail = viewModel.loadData(playlistId)
                ?: //TODO
                return@launch
            //show music list
            adapter.showList(viewModel.getLoginUser(), detail)
        }

        MusicPlayerManager.playingMusic.observe(this, Observer {
            val token = MusicPlayerManager.musicPlayer.playlist.token
            if (token == adapter.token) {
                adapter.changePlayingMusic(it)
            }
        })
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onPrimaryColorChanged(e: PrimaryColorEvent) {
        val color = e.color
        val alpha = toolbarBackground.alpha
        toolbarBackground.color = color
        toolbarBackground.alpha = alpha
        window.navigationBarColor = color
        adapter.applyPrimaryColor(color)

        //设置 recycler view 边界效果的颜色
        recyclerView.edgeEffectFactory = object : RecyclerView.EdgeEffectFactory() {
            override fun createEdgeEffect(view: RecyclerView, direction: Int): EdgeEffect {
                val effect = super.createEdgeEffect(view, direction)
                effect.color = color
                return effect
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
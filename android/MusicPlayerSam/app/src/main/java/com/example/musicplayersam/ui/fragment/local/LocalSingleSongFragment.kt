package com.example.musicplayersam.ui.fragment.local

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.R
import com.example.musicplayersam.player.MusicPlayerManager
import com.example.musicplayersam.repository.db.QuietDatabase
import com.example.musicplayersam.ui.fragment.base.BaseFragment
import com.example.musicplayersam.ui.item.MusicItemViewBinder
import com.example.musicplayersam.utils.*
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.LoggerLevel
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.component.support.CenterSmoothScroller
import com.example.musicplayersam.utils.component.support.attrValue
import com.example.musicplayersam.viewmodel.LocalMusicViewModel
import kotlinx.android.synthetic.main.fragment_local_single_song.*
import me.drakeet.multitype.MultiTypeAdapter
import tech.soit.quiet.model.vo.Music
import kotlin.math.abs

@LayoutId(R.layout.fragment_local_single_song)
class LocalSingleSongFragment : BaseFragment() {

    companion object {

        private const val TOKEN_PLAYLIST = "local_single_song"

        private const val SMOOTH_SCROLL_THRESHOLD = 50
    }

    private val viewModel by lazy { LocalMusicViewModel() }

    private val onPlayingItemShowHide = {show: Boolean ->
        if (show) {
            floatingButton.hide()
        } else {
            floatingButton.show()
        }
    }

    private lateinit var adapter: MultiTypeAdapter

    /**
     * boolean that [recyclerView] is scrolling to current playing music item
     *
     * this scroll will be process when [floatingButton] click invoked
     */
    private var autoScrolling = false

    /**
     * the target of [autoScrolling] process
     */
    private var autoScrollTarget = -1

    /**
     * animation to point out which item is playing
     */
    private var itemHintAnimator: ValueAnimator? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MultiTypeAdapter()
            .withEmptyBinder()
            .withLoadingBinder()
            .withBinder(
                MusicItemViewBinder(
                    TOKEN_PLAYLIST,
                    this::onMusicItemClick, onPlayingItemShowHide
                )
            )

        recyclerView.adapter = adapter
        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        floatingButton.setOnClickListener {
            val playlist = MusicPlayerManager.musicPlayer.playlist
            if (playlist.token != TOKEN_PLAYLIST) {
                return@setOnClickListener
            }
            val current = playlist.current ?: return@setOnClickListener
            val index = adapter.items.indexOf(current)
            if (index != -1) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val offset = index - firstVisibleItemPosition
                if (abs(offset) > SMOOTH_SCROLL_THRESHOLD) {
                    //if offset is too large, it might cost so many time to scroll
                    //of we scroll to the nearest position first
                    val pp = index - ((offset) / abs(offset)) * SMOOTH_SCROLL_THRESHOLD
                    recyclerView.scrollToPosition(pp)
                }
                val scroller = CenterSmoothScroller(it.context)
                scroller.targetPosition = index
                recyclerView.layoutManager?.startSmoothScroll(scroller)
                autoScrolling = true
                autoScrollTarget = index
            }
        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && autoScrolling && autoScrollTarget != -1) {
                    itemHintAnimator?.end()
                    val itemView = recyclerView.findViewHolderForAdapterPosition(autoScrollTarget)?.itemView
                    if (itemView != null) {//fast fail
                        val backup = itemView.background
                        itemView.setBackgroundColor(itemView.context.attrValue(R.attr.colorPrimary))
                        with(itemHintAnimator ?: ValueAnimator.ofInt(0, 255, 0)) {
                            itemHintAnimator = this
                            duration = 1000
                            addUpdateListener {
                                itemView.background.alpha = it.animatedValue as Int
                            }
                            doOnEnd {
                                itemView.background = backup
                            }
                            start()
                        }
                    }
                    autoScrolling = false
                    autoScrollTarget = -1
                }
            }
        })
    }

    init {
        viewModelFactory = object : ViewModelProvider.AndroidViewModelFactory(AppContext) {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(LocalMusicViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return LocalMusicViewModel(QuietDatabase.instance.localMusicDao()) as T
                }
                return super.create(modelClass)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.allMusics.observe(this, Observer {
                musics: List<Music>? ->
            when {
                musics == null -> adapter.submit(listOf(Loading))
                musics.isEmpty() -> adapter.submit(listOf(Empty))
                else -> adapter.submit(musics)
            }
        })
        MusicPlayerManager.playlist.observe(this, Observer { playlist ->
            if (playlist == null || playlist.token != TOKEN_PLAYLIST) {
                floatingButton.hide()
            }
        })
    }

    /**
     * call back when MusicItem been clicked
     *
     * @param view the item view
     * @param music the item
     */
    private fun onMusicItemClick(view: View, music: Music) {
        val playlist = MusicPlayerManager.musicPlayer.playlist
        if (playlist.token == TOKEN_PLAYLIST && music == playlist.current) {
            //to open player fragment
            val player = MusicPlayerManager.musicPlayer.mediaPlayer
            if (!player.isPlayWhenReady) {
                player.isPlayWhenReady = true
            }
        } else {
            val musics = adapter.items.filterIsInstance(Music::class.java)
            if (musics.isEmpty()) {
                log(LoggerLevel.ERROR) { "item clicked, but list is still null! token : $TOKEN_PLAYLIST" }
            }
            MusicPlayerManager.play(TOKEN_PLAYLIST, music, musics)
        }
    }

}
package com.example.musicplayersam.ui.adapter

import androidx.annotation.ColorInt
import androidx.core.view.children
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.player.MusicPlayerManager
import com.example.musicplayersam.ui.item.ItemMusicListHeader
import com.example.musicplayersam.ui.item.MusicItemViewBinder
import com.example.musicplayersam.ui.item.MusicViewHolder
import me.drakeet.multitype.MultiTypeAdapter
import tech.soit.quiet.model.vo.Music

open class MusicListAdapter(private val token: String) : MultiTypeAdapter() {

    private var recyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
        MusicPlayerManager.playingMusic.observeForever(playingMusicObserver)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
        MusicPlayerManager.playingMusic.removeObserver(playingMusicObserver)
    }

    private val musicItemViewBinder = MusicItemViewBinder(token,  { _, music ->
        MusicPlayerManager.play(token, music, musics)
    })

    /**
     * 监听音乐改变事件，只有当adapter attach 到 RecyclerView 上时才会进行监听
     */
    private val playingMusicObserver: Observer<Music?> = Observer {
        val index = items.indexOf(it)
        if (index == -1) {
            return@Observer
        }
        recyclerView?.let { view ->
            musicItemViewBinder.setCurrentPlaying(it, view)
        }
    }

    private var musics: List<Music> = emptyList()

    private var isMusicSet = false

    /**
     * @param isShowSubscribeButton flag to show subscribe button in music list header
     */
    fun showList(musics: List<Music>,
                 isShowSubscribeButton: Boolean,
                 isSubscribed: Boolean) {
        this.musics = musics
        isMusicSet = true

        val items = buildShowList(musics, isShowSubscribeButton, isSubscribed)
        this.items = items
        notifyDataSetChanged()
    }

    /**
     * 构建待显示的list，包括 header + music list
     */
    protected open fun buildShowList(musics: List<Music>,
                                     isShowSubscribeButton: Boolean,
                                     isSubscribed: Boolean): ArrayList<Any> {
        val items = ArrayList<Any>()
        items.add(ItemMusicListHeader(musics.size, isShowSubscribeButton, isSubscribed))
        items.addAll(musics)
        return items
    }

    /**
     * change music list primary color
     */
    fun applyPrimaryColor(@ColorInt colorPrimary: Int) {
        musicItemViewBinder.applyPrimaryColor(colorPrimary)
        val recyclerView = this.recyclerView ?: return
        recyclerView.children
            .mapNotNull {
                recyclerView.getChildViewHolder(it)
            }
            .filterIsInstance(MusicViewHolder::class.java)
            .forEach {
                it.setPrimaryColor(colorPrimary)
            }
    }

}
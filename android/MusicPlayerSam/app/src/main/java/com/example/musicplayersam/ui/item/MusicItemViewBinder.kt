package com.example.musicplayersam.ui.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.core.view.children
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.KItemViewBinder
import com.example.musicplayersam.utils.KViewHolder
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.support.attrValue
import kotlinx.android.synthetic.main.item_music.view.*
import tech.soit.quiet.model.vo.Music

@LayoutId(R.layout.item_music)
open class MusicItemViewBinder(
    private val token: String,
    private val onClick: (view: View, music: Music) -> Unit,
    private val onPlayingItemShowHide: ((show: Boolean) -> Unit)? = null
) : KItemViewBinder<Music>() {

    @ColorInt
    var colorIndicator: Int = AppContext.attrValue(R.attr.colorPrimary)

    fun applyPrimaryColor(@ColorInt color: Int) {
        colorIndicator = color
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): KViewHolder {
        return MusicViewHolder(inflater.inflate(R.layout.item_music, parent, false))
    }

    override fun onBindViewHolder(holder: KViewHolder, item: Music) {
        holder as MusicViewHolder
        if (colorIndicator != 0) {
            holder.setPrimaryColor(colorIndicator)
        }

        val isPlaying = isPlaying(item)
        holder.setIsPlaying(isPlaying)

        holder.itemView.setOnClickListener {
            onClick(holder.itemView, item)
        }

        holder.bind(item)
    }

    private fun isPlaying(music: Music): Boolean {
//        return MusicPlayerManager.musicPlayer.playlist.token == token
//                && MusicPlayerManager.musicPlayer.playlist.current == music
        return false
    }

    /**
     * 设置当前播放的音乐
     */
    fun setCurrentPlaying(music: Music?, recyclerView: RecyclerView) {
        recyclerView.children
            .map {
                recyclerView.getChildViewHolder(it)
            }
            .filterIsInstance<MusicViewHolder>()
            .forEach {
                it.setIsPlaying(it.musicId == music?.getId())
            }
    }
}

class MusicViewHolder(itemView: View): KViewHolder(itemView) {

    var musicId: Long = 0

    fun bind(item: Music) = with(itemView) {

        ImageLoader.with(this).load(item.getAlbum().getCoverImageUrl()).centerCrop().into(image)

        popup_menu.setOnClickListener {
            //
        }

        text_item_title.text = item.getTitle()
        text_item_subtitle.text = item.getArtists().joinToString("/") { it.getName() }
        text_item_subtitle_2.text = item.getAlbum().getName()

        musicId = item.getId()

    }

    fun setIsPlaying(isPlaying: Boolean) {
        itemView.indicatorPlaying.isGone = !isPlaying
    }


    /**
     * reset item view primary color
     */
    fun setPrimaryColor(@ColorInt color: Int) {
        itemView.indicatorPlaying.setBackgroundColor(color)
        itemView.divider_subtitle.setBackgroundColor(color)
    }
}
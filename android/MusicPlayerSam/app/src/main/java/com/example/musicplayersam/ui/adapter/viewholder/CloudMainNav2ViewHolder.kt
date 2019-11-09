package com.example.musicplayersam.ui.adapter.viewholder

import android.view.View
import androidx.core.view.isVisible
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.view.RoundRectOutlineProvider
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.support.px
import kotlinx.android.synthetic.main.item_cloud_nav_2.view.*

@LayoutId(R.layout.item_cloud_nav_2)
class CloudMainNav2ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {

        private val imageOutline = RoundRectOutlineProvider(3.px.toFloat())

    }

    init {
        itemView.run {
            imageCover.outlineProvider = imageOutline
            imageCover.clipToOutline = true
        }
    }

    fun set(title: String, image: Any) = itemView.run {
        textTitle.text = title
        ImageLoader.with(this).load(image).into(imageCover)
    }

    fun setPlayCount(playCount: Long) = itemView.run {

        val str: String = if (playCount > 10000) {
            "%d万".format(playCount / 10000)
        } else {
            playCount.toString()
        }
        textRightTop.text = str
    }


    fun setIsRightTopVisible(show: Boolean) {
        itemView.layoutRightTop.isVisible = show
    }


}
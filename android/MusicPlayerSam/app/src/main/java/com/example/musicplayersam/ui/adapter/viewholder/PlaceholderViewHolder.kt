package com.example.musicplayersam.ui.adapter.viewholder

import android.view.View
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.annotation.LayoutId
import kotlinx.android.synthetic.main.item_placeholder.view.*

/**
 * RecyclerView 空白占位
 */
@LayoutId(R.layout.item_placeholder)
class PlaceholderViewHolder(itemView: View) : BaseViewHolder(itemView) {


    override fun applyPrimaryColor(colorPrimary: Int) {
        itemView.progressBar.indeterminateDrawable.setTint(colorPrimary)
    }

}
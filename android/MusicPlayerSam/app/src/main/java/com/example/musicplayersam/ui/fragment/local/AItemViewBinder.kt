package com.example.musicplayersam.ui.fragment.local

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat.startActivity
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.KItemViewBinder
import com.example.musicplayersam.utils.KViewHolder
import com.example.musicplayersam.utils.TypeLayoutRes
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.support.attrValue
import kotlinx.android.synthetic.main.item_common_a.view.*

@TypeLayoutRes(R.layout.item_common_a)
class AItemViewBinder(
    private val onClick: ((position: Int) -> Unit)? = null,
    private val onLongClick: ((position: Int) -> Boolean)? = null
) : KItemViewBinder<AItem>() {

    override fun onBindViewHolder(holder: KViewHolder, item: AItem) = with(holder.itemView) {
        when {
            item.imageResource != 0 -> image.setImageResource(item.imageResource)
            item.imageUrl != null -> ImageLoader.with(image).load(item.imageUrl).into(image)
            else -> image.setImageDrawable(ColorDrawable(context.attrValue(R.attr.colorPrimary)))
        }

        textTitle.text = item.title
        textCaption.text = item.caption
        onClick?.let { action -> setOnClickListener { action(holder.adapterPosition) } }
        onLongClick?.let { action -> setOnLongClickListener { action(holder.adapterPosition) } }
        Unit
    }

}

class AItem(
    val title: String,
    val caption: String
) {

    constructor(@DrawableRes image: Int, title: String, caption: String) : this(title, caption) {
        imageResource = image
    }

    constructor(image: String, title: String, caption: String) : this(title, caption) {
        imageUrl = image
    }

    var imageResource: Int = 0
        private set

    var imageUrl: String? = null
        private set

}
package com.example.musicplayersam.ui.item

import androidx.core.view.isGone
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.KItemViewBinder
import com.example.musicplayersam.utils.KViewHolder
import com.example.musicplayersam.utils.TypeLayoutRes
import com.example.musicplayersam.utils.component.support.setOnClickListenerAsync
import com.example.musicplayersam.utils.component.support.string
import kotlinx.android.synthetic.main.header_music_list.view.*

class ItemMusicListHeader(
    val count: Int,
    val isShowSubscribeButton: Boolean,
    var isSubscribed: Boolean
)

@TypeLayoutRes(R.layout.header_music_list)
class MusicListHeaderViewBinder(
    private val onClicked: () -> Unit,
    private val onCollectionClicked: (suspend () -> Unit)? = null
) : KItemViewBinder<ItemMusicListHeader>() {

    override fun onBindViewHolder(holder: KViewHolder, item: ItemMusicListHeader) {
        with(holder.itemView) {
            textCollection.isGone = !item.isShowSubscribeButton
            textCollection.setOnClickListenerAsync {
                onCollectionClicked?.invoke()
            }
            if (!item.isSubscribed) {
                textCollection.setText(R.string.add_to_collection)
            } else {
                textCollection.setText(R.string.collected)
            }
            textMusicCount.text = string(R.string.template_item_play_list_count, item.count)
            setOnClickListener {
                onClicked()
            }
        }

    }

}
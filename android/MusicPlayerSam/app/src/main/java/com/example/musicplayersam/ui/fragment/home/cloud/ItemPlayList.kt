package com.example.musicplayersam.ui.fragment.home.cloud

import android.content.Intent
import android.view.View
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.view.RoundRectOutlineProvider
import com.example.musicplayersam.utils.KItemViewBinder
import com.example.musicplayersam.utils.KViewHolder
import com.example.musicplayersam.utils.TypeLayoutRes
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.support.px
import com.example.musicplayersam.utils.component.support.string
import kotlinx.android.synthetic.main.item_play_list.view.*
import tech.soit.quiet.model.vo.PlayListDetail

/**
 * cloud fragment 主页面的歌单列表 item
 */
@TypeLayoutRes(R.layout.item_play_list)
class PlayListViewBinder : KItemViewBinder<PlayListDetail>() {

    private val outlineProvider = RoundRectOutlineProvider(3.px.toFloat())

    override fun onViewCreated(view: View) {
        view.imageCover.apply {
            outlineProvider = this@PlayListViewBinder.outlineProvider
            clipToOutline = true
        }
    }

    override fun onBindViewHolder(holder: KViewHolder, item: PlayListDetail) {
        with(holder.itemView) {
            ImageLoader.with(this).load(item.getCoverUrl()).into(imageCover)
            textTitle.text = item.getName()
            textSubTitle.text = string(R.string.template_item_play_list_count, item.getTrackCount())
            setOnClickListener {
//                val intent = Intent(context, CloudPlayListDetailActivity::class.java)
//                intent.putExtra("id", item.getId())
//                intent.putExtra(CloudPlayListDetailActivity.PARAM_PLAY_LIST, item)
//                context.startActivity(intent)
            }
        }
    }

}
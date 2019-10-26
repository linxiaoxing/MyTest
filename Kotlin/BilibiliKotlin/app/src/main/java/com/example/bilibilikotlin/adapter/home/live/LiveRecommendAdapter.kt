package com.example.bilibilikotlin.adapter.home.live

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.bean.live.LiveRecommend
import com.example.bilibilikotlin.utils.NumberUtils

class LiveRecommendAdapter(data: List<LiveRecommend.RecommendData.Lives>)
    : BaseQuickAdapter<LiveRecommend.RecommendData.Lives, BaseViewHolder>(R.layout.layout_item_home_live_body_mul, data) {
    override fun convert(holder: BaseViewHolder, item: LiveRecommend.RecommendData.Lives) {
        Glide.with(mContext)
            .load(item.cover.src)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.bili_default_image_tv)
            .dontAnimate()
            .into(holder.getView<ImageView>(R.id.iv_video_preview))

        holder.setText(R.id.tv_video_live_up, item.owner.name)//up
            .setText(R.id.tv_video_online, NumberUtils.format("${item.online}"))//在线人数;

        holder.setText(R.id.tv_video_title, item.title)
    }
}
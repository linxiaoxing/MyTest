package com.example.bilibilikotlin.adapter.home

import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.bean.chase.ChaseBangumi
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.utils.SpanUtils

class ChaseFllowAdapter(data: List<ChaseBangumi.Follows>?) : BaseQuickAdapter<ChaseBangumi.Follows, BaseViewHolder>(
    R.layout.item_home_chase_body, data) {

    override fun convert(holder: BaseViewHolder, followsBean: ChaseBangumi.Follows) {
        Glide.with(mContext)
            .load(followsBean.cover)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.bili_default_image_tv)
            .dontAnimate()
            .into(holder.getView<ImageView>(R.id.iv_video_preview))
        holder.setText(R.id.tv_video_title, followsBean.title)//
        holder.setText(R.id.tv_video_update, SpanUtils()
            .append("更新至第 ${followsBean.new_ep.index} 话")
            .setForegroundColor(AppUtils.getColor(R.color.pink_text_color)).create())
        holder.setText(R.id.tv_video_state, "尚未观看")
        holder.itemView.setOnClickListener {
           // mContext.startActivity(Intent(mContext, BangumiDetailActivity::class.java))
        }

    }
}
package com.example.bilibilikotlin.adapter.home.section

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.bean.chase.RecommendBangumi
import com.example.bilibilikotlin.widget.section.StatelessSection
import com.example.bilibilikotlin.widget.section.ViewHolder

class ChaseAdSection(private val ad: RecommendBangumi.Ad) : StatelessSection<Nothing>(R.layout.layout_item_home_chase_footer, R.layout.layout_empty) {


    override fun onBindHeaderViewHolder(holder: ViewHolder) {
        Glide.with(mContext)
            .load<Any>(ad.img)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.bili_default_image_tv)
            .dontAnimate()
            .into(holder.getView<View>(R.id.iv_video_preview) as ImageView)
        holder.setVisible(R.id.tv_title, false)
            .setVisible(R.id.tv_new_tag, false)
            .setVisible(R.id.tv_des, false)

    }
}
package com.example.bilibilikotlin.adapter.home.section

import android.view.View
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.widget.section.StatelessSection
import com.example.bilibilikotlin.widget.section.ViewHolder

class ChaseIndexSection : StatelessSection<Nothing>(R.layout.layout_item_home_chase_bangumi_index, R.layout.layout_empty) {

    override fun onBindHeaderViewHolder(holder: ViewHolder) {
        holder.getView<View>(R.id.ll_bangumi_timeline)
                .setOnClickListener({
                    // mContext.startActivity(Intent(mContext, BangumiScheduleActivity::class.java))
                })
        holder.getView<View>(R.id.ll_bangumi_index)
                .setOnClickListener({
                    //mContext.startActivity(Intent(mContext, BangumiIndexActivity::class.java))
                })
    }
}
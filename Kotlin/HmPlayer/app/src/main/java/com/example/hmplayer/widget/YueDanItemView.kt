package com.example.hmplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.hmplayer.R

import com.example.hmplayer.model.YueDanBean
import kotlinx.android.synthetic.main.item_yuedan.view.*
import kotlinx.android.synthetic.main.item_yuedan.view.bg
import kotlinx.android.synthetic.main.item_yuedan.view.title

class YueDanItemView : RelativeLayout {

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context, attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

    fun setData(data: YueDanBean.PlayListsBean) {
        title.setText(data.title)
        // 歌手名称
        author_name.text = data.creator?.nickName
        // 歌曲数量
        count.text = data.videoCount.toString()
        // 头像
        Glide.with(this).load(data.playListPic).into(author_image)
        // 背景图
        Glide.with(this).load(data.thumbnailPic).into(bg)
    }
}
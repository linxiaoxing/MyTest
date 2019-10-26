package com.example.hmplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.hmplayer.R
import com.example.hmplayer.model.HomeItemBean
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView: RelativeLayout {

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context, attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_home, this)
    }

    fun setData(data: HomeItemBean) {
        title.setText(data.title)
        desc.setText(data.description)
        Glide.with(this).load(data.posterPic).into(bg)
    }

}
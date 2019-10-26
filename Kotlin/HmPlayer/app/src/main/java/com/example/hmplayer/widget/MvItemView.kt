package com.example.hmplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.hmplayer.R
import com.example.hmplayer.model.VideosBean

class MvItemView : RelativeLayout {

    fun setData(data: VideosBean) {

    }

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context, attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_mv, this)
    }
}
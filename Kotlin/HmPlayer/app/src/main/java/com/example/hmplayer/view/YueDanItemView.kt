package com.example.hmplayer.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.hmplayer.R

class YueDanItemView : RelativeLayout {

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context, attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

}
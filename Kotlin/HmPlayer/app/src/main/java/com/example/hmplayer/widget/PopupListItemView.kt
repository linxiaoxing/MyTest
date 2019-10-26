package com.example.hmplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.hmplayer.R
import com.example.hmplayer.model.AudioBean
import kotlinx.android.synthetic.main.item_popup.view.*

class PopupListItemView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_popup, this)
    }

    fun setData(itemBean: AudioBean) {
        title.text = itemBean.display_name
        artist.text = itemBean.artist
    }
}
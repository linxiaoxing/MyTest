package com.example.musicplayersam.ui.adapter.viewholder

import android.view.View
import androidx.annotation.ColorInt
import com.example.musicplayersam.utils.KViewHolder

open class BaseViewHolder(itemView: View) : KViewHolder(itemView) {


    open fun applyPrimaryColor(@ColorInt colorPrimary: Int) {

    }

}
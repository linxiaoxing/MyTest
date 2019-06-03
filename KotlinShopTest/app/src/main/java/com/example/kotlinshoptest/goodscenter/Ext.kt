package com.example.kotlinshoptest.goodscenter

import android.widget.EditText
import com.example.kotlinshoptest.R
import org.jetbrains.anko.find
import ren.qinc.numberbutton.NumberButton

/*
    三方控件扩展
 */
fun NumberButton.getEditText(): EditText {
    return find(R.id.text_count)
}

package com.example.musicplayersam.utils.component.support

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.musicplayersam.AppContext

/**
 * get theme data by Attr id
 */
fun Context.attrValue(@AttrRes id: Int): Int {
    val value = TypedValue()
    if (theme.resolveAttribute(id, value, true)) {
        value.data
        return value.data
    } else {
        error("can not attribute for : $id")
    }
}

/**
 * @see Context.getColor
 */
fun color(@ColorRes colorId: Int) = ContextCompat.getColor(AppContext, colorId)

/**
 * @see android.content.res.Resources.getDimension
 */
fun dimen(@DimenRes id: Int) = AppContext.resources.getDimension(id)

/**
 * @see Context.getString
 */
fun string(@StringRes stringId: Int) = AppContext.getString(stringId)!!

/**
 * @see Context.getString
 */
fun string(@StringRes stringId: Int, vararg formatArgs: Any) = string(stringId).format(*formatArgs)

/**
 * px to dp
 */
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * dp to px
 */
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
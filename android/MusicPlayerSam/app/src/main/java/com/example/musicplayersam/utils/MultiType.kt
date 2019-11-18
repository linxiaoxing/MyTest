package com.example.musicplayersam.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.annotation.LayoutId
import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter

open class KViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


@Deprecated("use LayoutId")
annotation class TypeLayoutRes(@LayoutRes val value: Int)

abstract class KItemViewBinder<T> : ItemViewBinder<T, KViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): KViewHolder {
        val layoutRes = (this::class.annotations.firstOrNull { it is TypeLayoutRes } as TypeLayoutRes?)?.value
            ?: this::class.java.getAnnotation(LayoutId::class.java)?.value
            ?: throw IllegalStateException("must override this function if you do not use Annotation")

        val view = inflater.inflate(layoutRes, parent, false)
        onViewCreated(view)
        return KViewHolder(view)
    }

    /**
     * callback when inflate a new item view by annotation
     */
    protected open fun onViewCreated(view: View) {

    }

    /**
     * link with [androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup]
     *
     * 此 itemView 所占的 span大小
     *
     */
    open val spanSize: Int = 1

}

inline fun <reified T, V : RecyclerView.ViewHolder, B : ItemViewBinder<T, V>> MultiTypeAdapter.withBinder(
    binder: B): MultiTypeAdapter {
    register(T::class.java, binder)
    return this
}

/**
 * shortcut to register Loading
 */
fun MultiTypeAdapter.withLoadingBinder(): MultiTypeAdapter {
    return withBinder(LoadingViewBinder())
}


fun MultiTypeAdapter.setLoading() {
    items = listOf(Loading)
}


/**
 * object for [LoadingViewBinder]
 */
object Loading

/*
 * easy access for loading
 */

@LayoutId(R.layout.item_loading)
class LoadingViewBinder : KItemViewBinder<Loading>() {

    override fun onBindViewHolder(holder: KViewHolder, item: Loading) {
        //do nothing
    }
}

fun MultiTypeAdapter.withEmptyBinder(): MultiTypeAdapter {
    return withBinder(EmptyViewBinder())
}



@LayoutId(R.layout.item_empty)
class EmptyViewBinder : KItemViewBinder<Empty>() {
    override fun onBindViewHolder(holder: KViewHolder, item: Empty) {
        //do nothing
    }

}

object Empty

fun MultiTypeAdapter.setEmpty() {
    items = listOf(Empty)
}

fun MultiTypeAdapter.submit(items: List<Any>) {
    this.items = items
    notifyDataSetChanged()
}



package com.example.hmplayer.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hmplayer.view.LoadMoreView

/**
 * @Description 所有适配器的基类
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW : View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>()  {

    private val list = ArrayList<ITEMBEAN>()

    /**
     * 更新数据操作
     */
    fun updateList(list: List<ITEMBEAN>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多数据
     */
    fun loadMore(list: List<ITEMBEAN>?) {
        list?.let {
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseListHolder {
        return if (p1 == 1) {
            BaseListHolder((LoadMoreView(p0.context)))
        } else {
            BaseListHolder(getItemView(p0.context))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) {
            // 最后一条
            1
        } else{
            // 普通条目
            0
        }
    }

    override fun onBindViewHolder(p0: BaseListHolder, p1: Int) {

        if (p1 == list.size) return

        val data = list[p1]
        val itemView = p0.itemView as ITEMVIEW
        refreshItemView(itemView, data)

        // 设置条目点击事件
        itemView.setOnClickListener {
            // 条目点击事件
            listener?.invoke(data)
        }
    }

    // 定义函数类型变量
    private var listener: ((itemBean: ITEMBEAN) -> Unit)? = null

    fun setMyListener(listener: ((itemBean: ITEMBEAN) -> Unit)) {
        this.listener = listener
    }

    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * 刷新条目view
     */
    abstract fun refreshItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    /**
     * 获取条目view
     */
    abstract fun getItemView(context: Context?): ITEMVIEW
}
package com.example.wankotlin.adapter

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wankotlin.R
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.mvp.model.bean.Article
import com.example.wankotlin.mvp.model.bean.NavigationBean
import com.example.wankotlin.utils.CommonUtil
import com.example.wankotlin.utils.DisplayManager
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout
import org.jetbrains.anko.startActivity

class NavigationAdapter(context: Context?, datas: MutableList<NavigationBean>)
    : BaseQuickAdapter<NavigationBean, BaseViewHolder>(R.layout.item_navigation_list, datas) {

    override fun convert(helper: BaseViewHolder?, item: NavigationBean?) {
        item ?: return
        helper?.setText(R.id.item_navigation_tv, item.name)
        val flowLayout: TagFlowLayout? = helper?.getView(R.id.item_navigation_flow_layout)
        val articles: List<Article> = item.articles
        flowLayout?.run {

            adapter = object : TagAdapter<Article>(articles) {
                override fun getView(parent: FlowLayout?, position: Int, article: Article?): View? {

                    val tv: TextView = LayoutInflater.from(parent?.context).inflate(R.layout.flow_layout_tv,
                        flowLayout, false) as TextView

                    article ?: return null

                    val padding: Int = DisplayManager.dip2px(10F)!!
                    tv.setPadding(padding, padding, padding, padding)
                    tv.text = article.title
                    tv.setTextColor(CommonUtil.randomColor())

                    setOnTagClickListener({ view, position, _ ->
                        val options: ActivityOptions = ActivityOptions.makeScaleUpAnimation(view,
                            view.width / 2,
                            view.height / 2,
                            0,
                            0)
                        var data: Article = articles[position]
//                        Intent(context, ContentActivity::class.java).run {
//                            putExtra(Constant.CONTENT_URL_KEY, data.link)
//                            putExtra(Constant.CONTENT_TITLE_KEY, data.title)
//                            putExtra(Constant.CONTENT_ID_KEY, data.id)
//                            context.startActivity(this, options.toBundle())
//                        }
                        true
                    })
                    return tv
                }
            }
        }
    }

}
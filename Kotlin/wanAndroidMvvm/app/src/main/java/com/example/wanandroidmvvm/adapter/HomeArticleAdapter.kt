package com.example.wanandroidmvvm.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wanandroidmvvm.R
import com.example.wanandroidmvvm.model.bean.Article

class HomeArticleAdapter(layoutResId: Int = R.layout.item_article):
    BaseQuickAdapter<Article, BaseViewHolder>(layoutResId) {

    var showStar = true

    fun showStar(showStar: Boolean) {
        this.showStar = showStar
    }

    override fun convert(helper: BaseViewHolder, item: Article) {
        helper.setText(R.id.articleTitle, Html.fromHtml(item.title))
            .setText(R.id.articleAuthor, item.author)
            .setText(R.id.articleTag, "${item.superChapterName ?: ""} ${item.chapterName}")
            .setText(R.id.articleTime, item.niceDate)
            .addOnClickListener(R.id.articleStar)
        if (showStar) helper.setImageResource(R.id.articleStar,
            if (item.collect) R.drawable.timeline_like_pressed else R.drawable.timeline_like_normal)
        else helper.setVisible(R.id.articleStar, false)
    }
}
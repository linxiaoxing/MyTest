package com.example.wanandroidmvvm.model.repository

import com.example.base.BaseRepository
import com.example.base.WanResponse
import com.example.wanandroidmvvm.model.api.WanRetrofitClient
import com.example.wanandroidmvvm.model.bean.ArticleList
import com.example.wanandroidmvvm.model.bean.Banner

class HomeRepository : BaseRepository() {

    suspend fun getBanners(): WanResponse<List<Banner>> {
        return apiCall {
            WanRetrofitClient.service.getBanner()
        }
    }

    suspend fun getArticleList(page: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.getHomeArticles(page) }
    }

    suspend fun collectArticle(articleId: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.collectArticle(articleId) }
    }

    suspend fun unCollectArticle(articleId: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.cancelCollectArticle(articleId) }
    }
}

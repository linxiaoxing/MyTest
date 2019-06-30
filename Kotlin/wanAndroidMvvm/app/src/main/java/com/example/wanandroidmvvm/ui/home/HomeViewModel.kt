package com.example.wanandroidmvvm.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.base.BaseViewModel
import com.example.wanandroidmvvm.model.bean.ArticleList
import com.example.wanandroidmvvm.model.bean.Banner
import com.example.wanandroidmvvm.model.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel: BaseViewModel() {

    private val repository by lazy {
        HomeRepository()
    }

    val mBanners: MutableLiveData<List<Banner>> = MutableLiveData()
    val mArticleList: MutableLiveData<ArticleList> = MutableLiveData()

    fun getBanners() {
        launch {
            val result = withContext(Dispatchers.IO) { repository.getBanners() }
            executeResponse(result, { mBanners.value = result.data }, {})
        }
    }

    fun getArticleList(page: Int) {
        launch {
            val result = withContext(Dispatchers.IO) { repository.getArticleList(page) }
            executeResponse(result, { mArticleList.value = result.data }, {})
        }
    }

    fun collectArticle(articleId: Int, boolean: Boolean) {
        launch {
            val result = withContext(Dispatchers.IO) {
                if (boolean) repository.collectArticle(articleId)
                else repository.unCollectArticle(articleId)
            }
        }
    }
}
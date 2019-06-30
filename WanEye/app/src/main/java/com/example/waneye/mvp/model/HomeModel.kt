package com.example.waneye.mvp.model

import android.content.Context
import com.example.waneye.mvp.model.bean.HomeBean
import com.example.waneye.network.ApiService
import com.example.waneye.network.RetrofitClient
import io.reactivex.Observable

class HomeModel{
    fun loadData(context: Context, isFirst: Boolean, data: String?): Observable<HomeBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService  = retrofitClient.create(ApiService::class.java)
        when(isFirst) {
            true -> return apiService?.getHomeData()

            false -> return apiService?.getHomeMoreData(data.toString(), "2")
        }
    }
}
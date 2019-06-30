package com.example.waneye.mvp.model

import android.content.Context
import com.example.waneye.mvp.model.bean.FindBean
import com.example.waneye.network.ApiService
import com.example.waneye.network.RetrofitClient
import io.reactivex.Observable

class FindModel() {
    fun loadData(context: Context): Observable<MutableList<FindBean>>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindData()
    }
}
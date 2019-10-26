package com.example.hmplayer.net

import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.presenter.impl.HomePresenterImpl
import com.example.hmplayer.ui.fragment.HomeFragment
import com.example.hmplayer.util.ThreadUtil
import com.example.hmplayer.util.URLProviderUtils
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

/**
 * @Description 发送网络请求类
 */
class NetManager private constructor() {

    private val client by lazy { OkHttpClient() }

    companion object {
        val manager by lazy { NetManager() }
    }

    fun <T> sendRequest(type: Int, req: MRequest<T>, fragment: BaseFragment?) {
        //val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(req.url)
            .get()
            .build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

                println("获取数据出错：" + Thread.currentThread().name)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        req.handler.onError(e.message)
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                println("获取数据成功：" + Thread.currentThread().name)
                var result = ""
                if (response.code() != 200) {
                    println("获取数据出错：" + Thread.currentThread().name)
                    if (fragment is HomeFragment) {
                        result = HomePresenterImpl.jsonStr
                    } else {
                        result = YueDanBean.yueDanJson
                    }
                } else {
                    result = response?.body()?.string()!!
                }
                println("数据:" + result)
                val gson = Gson()
                val list = req.parseResult(result)
                // println("获取数据成功：" + list.size)

                //更新処理(Main Thread)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        req.handler.onSuccess(type, list)
                    }
                })
            }
        })
    }
}
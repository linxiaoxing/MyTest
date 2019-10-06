package com.example.hmplayer.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hmplayer.R
import com.example.hmplayer.adapter.HomeAdapter
import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.util.ThreadUtil
import com.example.hmplayer.util.URLProviderUtils
import com.example.hmplayer.view.HomeItemView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_list.*
import okhttp3.*
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast
import java.io.IOException

class HomeFragment : BaseFragment() {

    val adapter by lazy { HomeAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
    }

    override fun initData() {
        loadDatas()
    }

    private fun loadDatas() {
        val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

                println("获取数据出错：" + Thread.currentThread().name)
            }

            override fun onResponse(call: Call, response: Response) {
                println("获取数据成功：" + Thread.currentThread().name)
                var result = ""
                if (response.code() != 200) {
                    println("获取数据出错：" + Thread.currentThread().name)
                    myToast("获取数据出错：" + Thread.currentThread().name)
                    result =
                            "[{\n" +
                            "                        \"type\": \"VIDEO\",\n" +
                            "                        \"id\": \"3028080\",\n" +
                            "                        \"title\": \"whisper完整版\",\n" +
                            "                        \"description\": \"VIXX LR\",\n" +
                            "                        \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                        \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                        \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                        \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                        \"videoSize\": 88,\n" +
                            "                        \"hdVideoSize\": 0,\n" +
                            "                        \"uhdVideoSize\": 0,\n" +
                            "                        \"status\": 200,\n" +
                            "                        \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                        \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                        \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                    },\n" +
                            "                        {\n" +
                            "                            \"type\": \"VIDEO\",\n" +
                            "                            \"id\": \"3028080\",\n" +
                            "                            \"title\": \"whisper完整版\",\n" +
                            "                            \"description\": \"VIXX LR\",\n" +
                            "                            \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                            \"videoSize\": 88,\n" +
                            "                            \"hdVideoSize\": 0,\n" +
                            "                            \"uhdVideoSize\": 0,\n" +
                            "                            \"status\": 200,\n" +
                            "                            \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                        },\n" +
                            "                        {\n" +
                            "                            \"type\": \"VIDEO\",\n" +
                            "                            \"id\": \"3028080\",\n" +
                            "                            \"title\": \"whisper完整版\",\n" +
                            "                            \"description\": \"VIXX LR\",\n" +
                            "                            \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                            \"videoSize\": 88,\n" +
                            "                            \"hdVideoSize\": 0,\n" +
                            "                            \"uhdVideoSize\": 0,\n" +
                            "                            \"status\": 200,\n" +
                            "                            \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                        },\n" +
                            "                        {\n" +
                            "                            \"type\": \"VIDEO\",\n" +
                            "                            \"id\": \"3028080\",\n" +
                            "                            \"title\": \"whisper完整版\",\n" +
                            "                            \"description\": \"VIXX LR\",\n" +
                            "                            \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                            \"videoSize\": 88,\n" +
                            "                            \"hdVideoSize\": 0,\n" +
                            "                            \"uhdVideoSize\": 0,\n" +
                            "                            \"status\": 200,\n" +
                            "                            \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                        },\n" +
                            "                        {\n" +
                            "                            \"type\": \"VIDEO\",\n" +
                            "                            \"id\": \"3028080\",\n" +
                            "                            \"title\": \"whisper完整版\",\n" +
                            "                            \"description\": \"VIXX LR\",\n" +
                            "                            \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                            \"videoSize\": 88,\n" +
                            "                            \"hdVideoSize\": 0,\n" +
                            "                            \"uhdVideoSize\": 0,\n" +
                            "                            \"status\": 200,\n" +
                            "                            \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                        },\n" +
                            "                        {\n" +
                            "                            \"type\": \"VIDEO\",\n" +
                            "                            \"id\": \"3028080\",\n" +
                            "                            \"title\": \"whisper完整版\",\n" +
                            "                            \"description\": \"VIXX LR\",\n" +
                            "                            \"posterPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"thumbnailPic\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"url\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"hdUrl\": \"http://www.bejson.com\",\n" +
                            "                            \"videoSize\": 88,\n" +
                            "                            \"hdVideoSize\": 0,\n" +
                            "                            \"uhdVideoSize\": 0,\n" +
                            "                            \"status\": 200,\n" +
                            "                            \"traceUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"clickUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\",\n" +
                            "                            \"uhdUrl\": \"http://img2.c.yinyuetai.com/others/frontPageRec/190920/0/-M-bc58b446a4775a8968f7d892d1d5b90b_0x0.jpg\"\n" +
                            "                        }\n" +
                            "                    ]"
                } else {
                    result = response?.body()?.string()!!
                }
                println("数据:"+result)
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(
                    result,
                    object : TypeToken<List<HomeItemBean>>() {}.type
                )
                println("获取数据成功：" + list.size)

                //更新処理(Main Thread)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        adapter.updateList(list)
                    }
                })
            }
        })
    }

}
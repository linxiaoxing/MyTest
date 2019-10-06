package com.example.hmplayer.presenter.impl

import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.net.HomeRequest
import com.example.hmplayer.net.ResponseHandler
import com.example.hmplayer.presenter.interf.HomePresenter
import com.example.hmplayer.view.HomeView

class HomePresenterImpl(var homeView: HomeView) : HomePresenter,
    ResponseHandler<List<HomeItemBean>> {

    override fun loadMore(offset: Int) {
        HomeRequest(HomePresenter.TYPE_LOAD_MORE, offset, this).execute()
//        NetManager.manager.sendRequest(request)

//        val path = URLProviderUtils.getHomeUrl(offset, 20)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//        client.newCall(request).enqueue(object : Callback {
//
//            override fun onFailure(call: Call, e: IOException) {
//
//                println("获取数据出错：" + Thread.currentThread().name)
//                homeView.onError(e.message)
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                println("获取数据成功：" + Thread.currentThread().name)
//                var result = ""
//                if (response.code() != 200) {
//                    println("获取数据出错：" + Thread.currentThread().name)
//                    result = jsonStr
//
//                } else {
//                    result = response?.body()?.string()!!
//                }
//                println("数据:" + result)
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(
//                    result,
//                    object : TypeToken<List<HomeItemBean>>() {}.type
//                )
//                println("获取数据成功：" + list.size)
//
//                //更新処理(Main Thread)
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        //adapter.loadMore(list)
//                        homeView.loadMoreSuccessed(list)
//                    }
//                })
//            }
//        })
    }

    override fun loadDatas() {
        HomeRequest(HomePresenter.TYPE_INIT_OR_REFRESH,0, this).execute()
//        NetManager.manager.sendRequest(request)

//        val path = URLProviderUtils.getHomeUrl(0, 20)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//        client.newCall(request).enqueue(object : Callback {
//
//            override fun onFailure(call: Call, e: IOException) {
//
//                println("获取数据出错：" + Thread.currentThread().name)
//                //runOnUiThread { refreshLayout.isRefreshing = false }
//                homeView.onError(e.message)
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                println("获取数据成功：" + Thread.currentThread().name)
//                var result = ""
//                if (response.code() != 200) {
//                    println("获取数据出错：" + Thread.currentThread().name)
//                    result = jsonStr
//                } else {
//                    result = response?.body()?.string()!!
//                }
//                println("数据:" + result)
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(
//                    result,
//                    object : TypeToken<List<HomeItemBean>>() {}.type
//                )
//                println("获取数据成功：" + list.size)
//
//                //更新処理(Main Thread)
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        homeView.loadSuccessed(list)
//                    }
//                })
//            }
//        })
    }

    override fun onError(msg: String?) {
        homeView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {

        when(type) {
            HomePresenter.TYPE_INIT_OR_REFRESH-> homeView.loadSuccessed(result)
            HomePresenter.TYPE_LOAD_MORE-> homeView.loadMoreSuccessed(result)
        }
    }

    companion object {
        val jsonStr = "[{\n" +
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
    }

}
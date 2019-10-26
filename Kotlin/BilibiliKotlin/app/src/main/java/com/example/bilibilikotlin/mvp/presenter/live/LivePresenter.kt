package com.example.bilibilikotlin.mvp.presenter.live

import com.example.bilibilikotlin.App
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.live.LivePartition
import com.example.bilibilikotlin.bean.live.MulLive
import com.example.bilibilikotlin.mvp.contract.home.LiveContract
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.network.response.HttpResponse
import com.example.bilibilikotlin.rx.handleResult
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import com.google.gson.Gson
import org.json.JSONObject
import java.io.InputStream
import javax.inject.Inject

class LivePresenter @Inject constructor(private val retrofitHelper: RetrofitHelper) :
    RxPresenter<LiveContract.View>(), LiveContract.Presenter<LiveContract.View> {

    var livePartition: LivePartition? = null
    override fun getLiveData() {
        val mulLives: MutableList<MulLive> = mutableListOf()

//        addSubscribe(retrofitHelper.getLivePartition()
//            .compose(handleResult())
//            .flatMap({
//                livePartition = it
//                retrofitHelper.getLiveRecommend()
//            })
        addSubscribe(
            retrofitHelper.getLiveRecommend()
                .compose(handleResult())
                .map {
                    setLivePartition()
                    with(it.recommend_data) {
                        val allot = lives.size.div(2)
                        mulLives += MulLive(
                            itemTypez = MulLive.TYPE_BANNER,
                            bannerBeanList = livePartition?.banner
                        )//轮播条
                        mulLives += MulLive(itemTypez = MulLive.TYPE_ENTRANCE)//入口
                        if (banner_data == null) {
                            mulLives += MulLive(
                                itemTypez = MulLive.TYPR_HEADER,
                                title = partition.name,
                                url = partition.sub_icon.src,
                                count = partition.count
                            )
                            mulLives += MulLive(
                                itemTypez = MulLive.TYPE_RECOMMEND_ITEM,
                                recommendLives = lives
                            )
                            mulLives += MulLive(hasMore = false, itemTypez = MulLive.TYPE_FOOTER)
                        } else {
                            if (banner_data.size == 1) {
                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPR_HEADER,
                                    title = partition.name,
                                    url = partition.sub_icon.src,
                                    count = partition.count
                                )

                                val part1 = lives.subList(0, allot) //主体
                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_ITEM,
                                    recommendLives = part1
                                )

                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_BANNER,
                                    bannerData = (banner_data)[0]
                                )


                                val part2 = lives.subList(allot, (lives.size))
                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_ITEM,
                                    recommendLives = part2
                                )


                                mulLives += MulLive(
                                    hasMore = false,
                                    itemTypez = MulLive.TYPE_FOOTER
                                )

                            } else {

                                mulLives += MulLive(
                                    itemTypez = MulLive.Companion.TYPR_HEADER,
                                    title = partition.name,
                                    url = partition.sub_icon.src,
                                    count = partition.count
                                )

                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_BANNER,
                                    bannerData = (banner_data)[0]
                                )

                                val part1 = lives.subList(0, allot) //主体
                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_ITEM,
                                    recommendLives = part1
                                )

                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_BANNER,
                                    bannerData = (banner_data)[1]
                                )

                                val part2 = lives.subList(allot, (lives.size))
                                mulLives += MulLive(
                                    itemTypez = MulLive.TYPE_RECOMMEND_ITEM,
                                    recommendLives = part2
                                )

                                mulLives += MulLive(
                                    hasMore = false,
                                    itemTypez = MulLive.TYPE_FOOTER
                                )

                            }
                        }
                    }
                    livePartition?.partitions?.let {
                        for ((index, element) in it.withIndex()) {
                            mulLives += MulLive(
                                itemTypez = MulLive.TYPR_HEADER,
                                title = element.partition.name,
                                url = element.partition.sub_icon.src,
                                count = element.partition.count
                            )
                            val part = element.lives.subList(0, 4)
                            mulLives += MulLive(
                                itemTypez = MulLive.TYPE_PARTY_ITEM,
                                partityLives = part
                            )
                            if (index == it.size.minus(1)) {
                                mulLives += MulLive(hasMore = true, itemTypez = MulLive.TYPE_FOOTER)
                            } else {
                                mulLives += MulLive(
                                    hasMore = false,
                                    itemTypez = MulLive.TYPE_FOOTER
                                )
                            }
                        }
                    }
                    mulLives
                }
                .compose(rxSchedulerHelper())
                .subscribe {
                    mView?.complete()
                    mView?.showMulLive(it)
                })
    }

    fun setLivePartition() {
        val responseBody: JSONObject = JSONObject(readJSONFromAsset())
        val livePartitionJson = responseBody.getJSONObject("data").toString()
        livePartition =
            Gson().fromJson(livePartitionJson, LivePartition::class.java)

    }

    fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = App.instance.assets.open("common.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
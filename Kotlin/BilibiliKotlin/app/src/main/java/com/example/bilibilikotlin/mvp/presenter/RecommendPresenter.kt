package com.example.bilibilikotlin.mvp.presenter

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment
import com.example.bilibilikotlin.bean.recommend.Recommend
import com.example.bilibilikotlin.mvp.contract.home.RecommendContract
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import com.example.bilibilikotlin.utils.JsonUtils
import com.google.gson.Gson
import com.google.gson.JsonParser
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * * 描述:首页直播Presenter
 */
class RecommendPresenter @Inject constructor(private val retrofitHelper: RetrofitHelper) : RxPresenter<RecommendContract.View>(), RecommendContract.Presenter<RecommendContract.View> {

    override fun getRecommendData() {
        //需登录
        /*BaseListSubscriber<Recommend> subscriber = mRetrofitHelper.getRecommend()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<Recommend>(mView) {
                    @Override
                    public void onSuccess(List<Recommend> recommends) {
                        mView.showRecommend(recommends);
                    }
                });
        addSubscribe(subscriber);*/
        addSubscribe(
            Flowable.just(JsonUtils.readJson("recommend.json"))
            .map<List<Recommend>> {
                val gson = Gson()
                val `object` = JsonParser().parse(it).asJsonObject
                val array = `object`.getAsJsonArray("data")
                val recommends = array.map { gson.fromJson(it, Recommend::class.java) }
                recommends
            }
            .compose(rxSchedulerHelper())
            .subscribeWith(object : BaseSubscriber<List<Recommend>>(mView) {
                override fun onSuccess(t: List<Recommend>) {
                    mView?.showRecommend(t)
                }
            }))
    }
}
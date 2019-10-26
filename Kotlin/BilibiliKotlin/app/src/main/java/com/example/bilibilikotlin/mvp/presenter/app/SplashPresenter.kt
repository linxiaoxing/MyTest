package com.example.bilibilikotlin.mvp.presenter.app

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.app.Splash
import com.example.bilibilikotlin.mvp.contract.SplashContract
import com.example.bilibilikotlin.network.helper.RetrofitHelper
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val retrofitHelper: RetrofitHelper):
    RxPresenter<SplashContract.View>(), SplashContract.Presenter<SplashContract.View> {

    override fun setCountDown() {
        val count = 5L
        addSubscribe(
            Flowable.interval(0, 1, TimeUnit.SECONDS)
            .map { count - it }
            .take(count + 1)
            .compose(rxSchedulerHelper())
            .subscribe { mView?.showCountDown(it.toInt()) })
    }

    override fun getSplashData() {
        addSubscribe(retrofitHelper.getSplash()
            .compose(rxSchedulerHelper())
            .subscribeWith(object : BaseSubscriber<Splash>(mView) {
                override fun onSuccess(t: Splash) {
                    if (t.code == 0) mView?.showSplash(t)
                }

                override fun onFailure(code: Int, message: String) {
                    mView?.showError(message)
                }
            }))
    }
}
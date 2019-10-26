package com.example.bilibilikotlin.mvp.presenter.app.video

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.app.video.MulSummary
import com.example.bilibilikotlin.event.Event
import com.example.bilibilikotlin.mvp.contract.app.video.SummaryContract
import com.example.bilibilikotlin.rx.RxBus
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import javax.inject.Inject

class SummaryPresenter @Inject
constructor() : RxPresenter<SummaryContract.View>(), SummaryContract.Presenter<SummaryContract.View> {

    override fun getSummaryData() {
        addSubscribe(RxBus.toFlowable(Event.VideoDetailEvent::class.java)
            .map({ videoDetailEvent ->
                val videoDetail = videoDetailEvent.videoDetail

                val mulSummaries = mutableListOf<MulSummary>()
                mulSummaries += MulSummary(
                    itemTypez = MulSummary.TYPE_DES,
                    title = videoDetail?.title,
                    desc = videoDetail?.desc,
                    state = videoDetail?.stat)
                mulSummaries += MulSummary(itemTypez = MulSummary.TYPE_OWNER,
                    owner = videoDetail?.owner,
                    ctime = videoDetail?.ctime?.toLong() ?: 0,
                    tags = videoDetail?.tag)

                mulSummaries += MulSummary(itemTypez = MulSummary.TYPE_RELATE_HEAD)

                videoDetail?.relates?.forEach {
                    mulSummaries += MulSummary(itemTypez = MulSummary.TYPE_RELATE, relates = it)
                }
                mulSummaries
            })
            .compose(rxSchedulerHelper())
            .subscribeWith(object : BaseSubscriber<List<MulSummary>>(mView) {
                override fun onSuccess(t: List<MulSummary>) {
                    mView?.showSummary(t)
                }
            }))
    }
}
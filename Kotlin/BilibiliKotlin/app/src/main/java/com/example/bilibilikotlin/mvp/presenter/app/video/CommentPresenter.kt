package com.example.bilibilikotlin.mvp.presenter.app.video

import com.example.bilibilikotlin.base.BaseSubscriber
import com.example.bilibilikotlin.base.RxPresenter
import com.example.bilibilikotlin.bean.app.video.MulComment
import com.example.bilibilikotlin.event.Event
import com.example.bilibilikotlin.mvp.contract.app.video.CommentContract
import com.example.bilibilikotlin.rx.RxBus
import com.example.bilibilikotlin.rx.rxSchedulerHelper
import javax.inject.Inject

class CommentPresenter @Inject constructor() : RxPresenter<CommentContract.View>(), CommentContract.Presenter<CommentContract.View> {

    override fun getCommentData() {
        addSubscribe(
            RxBus.toFlowable(Event.VideoDetailCommentEvent::class.java)
            .map {
                val videoDetailComment = it.videoDetailComment
                val mulComments = mutableListOf<MulComment>()
                videoDetailComment?.hots?.forEach {
                    mulComments.add(MulComment(itemTypez = MulComment.TYPE_COMMENT_HOT_ITEM, hotsBean = it))
                }
                mulComments.add(MulComment(itemTypez = MulComment.TYPE_COMMENT_MORE))

                videoDetailComment?.replies?.forEach {
                    mulComments.add(MulComment(
                        itemTypez = MulComment.TYPE_COMMENT_NOMAL_ITEM,
                        repliesBean = it))
                }
                mulComments
            }
            .compose(rxSchedulerHelper())
            .subscribeWith(object : BaseSubscriber<List<MulComment>>(mView) {
                override fun onSuccess(t: List<MulComment>) {
                    mView!!.showComment(t)
                }
            }))

    }
}
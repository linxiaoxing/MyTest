package com.example.bilibilikotlin.mvp.contract.app.video

import com.example.bilibilikotlin.base.BaseContract
import com.example.bilibilikotlin.bean.app.video.MulComment

/**
 * * 描述:欢迎界面Contract
 */

interface CommentContract {
    interface View : BaseContract.BaseView {
        fun showComment(mulComments: List<MulComment>)
    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getCommentData()


    }
}
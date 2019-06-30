package com.example.waneye.mvp.presenter

import android.content.Context
import com.example.waneye.mvp.contract.ResultContract
import com.example.waneye.mvp.model.ResultModel
import com.example.waneye.mvp.model.bean.HotBean
import com.example.waneye.utils.applySchedulers
import io.reactivex.Observable

class ResultPresenter(context: Context, view: ResultContract.View) : ResultContract.Presenter {


    var mContext: Context? = null
    var mView: ResultContract.View? = null
    val mModel: ResultModel by lazy {
        ResultModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {

    }

    override fun requestData(query: String, start: Int) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!, query, start) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

}
package com.example.waneye.mvp.presenter

import android.content.Context
import com.example.waneye.mvp.contract.HotContract
import com.example.waneye.mvp.model.HotModel
import com.example.waneye.mvp.model.bean.HotBean
import com.example.waneye.utils.applySchedulers
import io.reactivex.Observable

class HotPresenter(context: Context,view: HotContract.View) : HotContract.Presenter{


    var mContext : Context? = null
    var mView : HotContract.View? = null
    val mModel : HotModel by lazy {
        HotModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {

    }
    override fun requestData(strategy: String) {
        val observable : Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!,strategy) }
        observable?.applySchedulers()?.subscribe { bean : HotBean ->
            mView?.setData(bean)
        }
    }

}

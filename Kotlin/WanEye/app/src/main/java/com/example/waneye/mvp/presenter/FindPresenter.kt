package com.example.waneye.mvp.presenter

import android.content.Context
import com.example.waneye.mvp.contract.FindContract
import com.example.waneye.mvp.model.FindModel
import com.example.waneye.mvp.model.bean.FindBean
import com.example.waneye.utils.applySchedulers
import io.reactivex.Observable

class FindPresenter(context: Context, view : FindContract.View) : FindContract.Presenter{
    var mContext : Context? = null
    var mView : FindContract.View? = null
    val mModel : FindModel by lazy {
        FindModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable : Observable<MutableList<FindBean>>? = mContext?.let { mModel.loadData(mContext!!) }
        observable?.applySchedulers()?.subscribe { beans : MutableList<FindBean> ->
            mView?.setData(beans)
        }
    }
}

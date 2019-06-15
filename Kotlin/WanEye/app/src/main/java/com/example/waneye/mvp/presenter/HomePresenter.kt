package com.example.waneye.mvp.presenter

import android.content.Context
import com.example.waneye.mvp.contract.HomeContract
import com.example.waneye.mvp.model.HomeModel
import com.example.waneye.mvp.model.bean.HomeBean
import com.example.waneye.utils.applySchedulers
import io.reactivex.Observable

class HomePresenter(context: Context, view : HomeContract.View) : HomeContract.Presenter{
    var mContext : Context? = null
    var mView : HomeContract.View? = null
    val mModel : HomeModel by lazy {
        HomeModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,true,"0") }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }
    fun moreData(data: String?){
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,false,data) }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }


}


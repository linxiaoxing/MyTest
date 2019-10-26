package com.example.bilibilikotlin.base

import com.example.bilibilikotlin.network.exception.ApiException
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.utils.LogUtils
import com.example.bilibilikotlin.utils.net.NetworkUtils
import io.reactivex.subscribers.ResourceSubscriber
import retrofit2.HttpException
import java.net.SocketTimeoutException

/**
 * 描述:统一处理订阅者
 */

abstract class BaseSubscriber<T>(private val view: BaseContract.BaseView?) : ResourceSubscriber<T>() {

    private var msg: String? = null

    abstract fun onSuccess(t: T)

    constructor(view: BaseContract.BaseView?, msg: String?) : this(view) {
        this.msg = msg
    }

    open fun onFailure(code: Int, message: String) {
        this.msg = message
    }

    override fun onStart() {
        super.onStart()
        if (!NetworkUtils.isConnected(AppUtils.getAppContext())) {
            // Logger.d("没有网络");
        } else {

        }
    }

    override fun onComplete() {

    }

    override fun onNext(response: T) {
        view?.let {
            it.complete()
            onSuccess(response)
        } ?: return@onNext
    }


    override fun onError(e: Throwable) {
        view?.let {
            if (!msg.isNullOrEmpty()) it.showError(msg!!)
            else {
                when (e) {
                    is ApiException -> it.showError(e.toString())
                    is SocketTimeoutException -> it.showError("服务器响应超时ヽ(≧Д≦)ノ")
                    is HttpException -> it.showError("数据加载失败ヽ(≧Д≦)ノ")
                    else -> {
                        view.showError("未知错误ヽ(≧Д≦)ノ")
                        LogUtils.e("MYERROR:" + e.toString())
                    }
                }
            }
        } ?: return
    }
}

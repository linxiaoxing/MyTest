package com.example.kotlinshoptest.baselibrary.ext

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.baselibrary.data.protocol.BaseResp
import com.example.baselibrary.utils.GlideUtils
import com.example.kotlinshoptest.baselibrary.rx.BaseFunc
import com.example.kotlinshoptest.baselibrary.rx.BaseFuncBoolean
import com.example.kotlinshoptest.baselibrary.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

fun View.OnClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.OnClick(method: () -> Unit) {
    this.setOnClickListener {
        method()
    }
}

/**
 *  扩展视图可见性
 */
fun View.setVisible(visible:Boolean){
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * 扩展Observable执行
 */
fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>,
                             lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

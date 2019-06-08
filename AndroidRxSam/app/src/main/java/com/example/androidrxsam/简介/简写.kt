package com.example.androidrxsam.简介

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
class 简写 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，间隔1秒发射数据
        val observable = createObservable()
        //建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // onNext回调
                text.append("$it\n")
            }, {
                // onError回调
                text.append(it.message)
            }, {
                // onComplete回调
                text.append("complete.")
            }, {
                // onSubscribe回调
                text.append("subscribe\n")
            })
    }

    private fun createObservable(): Observable<Long> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
            .take(10)
    }
}

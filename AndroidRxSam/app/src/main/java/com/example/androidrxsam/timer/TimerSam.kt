package com.example.androidrxsam.timer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
//timer操作延迟发射一个0L

class TimerSam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，发出Long数据
        val observable = createObservable()
        //创建一个观察者，接收Long数据
        val observer = createObserver()
        //建立订阅
        observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    private fun createObservable(): Observable<Long> {
        return Observable.timer(1, TimeUnit.SECONDS)
    }

    private fun createObserver(): Observer<Long> {
        return object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
            }

            override fun onNext(long: Long) {
                text.append("$long\n")
            }

            override fun onComplete() {
                text.append("complete.")
            }

            override fun onError(e: Throwable) {
                text.append(e.message)
            }
        }
    }
}
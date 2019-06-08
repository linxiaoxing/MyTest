package com.example.androidrxsam.just

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class JustSample: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，发出整型数据
        val observable = createObservable()

        //创建一个观察者，接收整型数据
        val observer = createObserver()

        //建立订阅
        observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    /**
     * 创建第一个被观察者，发射0~9
     */
    private fun createObservable(): Observable<Int> {
        return Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    private fun createObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
            }

            override fun onNext(integer: Int) {
                text.append("$integer\n")
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
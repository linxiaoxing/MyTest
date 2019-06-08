package com.example.androidrxsam.merge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MergeSam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建第一个被观察者，发射"1","2","3","4","5"
        val observable1 = createObservable1()
        // 创建第二个被观察者，发射"a","b","c"
        val observable2 = createObservable2()

        val observable3 = createObservable3()

        val observable4 = createObservable4()
        // 创建一个观察者，接收字符串数据
        val observer = createObserver()
        // 建立订阅，使用merge操作将两个被观察者发射的数据合并发射
        Observable.merge(observable1, observable2).subscribe(observer)

        // 建立订阅，使用merge操作将两个被观察者发射的数据合并发射
        Observable.merge(observable3, observable4)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    private fun createObservable1(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }

    private fun createObservable2(): Observable<String> {
        return Observable.just("a", "b", "c")
    }

    private fun createObservable3(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
            .delay(1, TimeUnit.SECONDS)
    }

    private fun createObservable4(): Observable<String> {
        return Observable.just("a", "b", "c")
    }

    private fun createObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
            }

            override fun onNext(data: String) {
                text.append("$data\n")
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
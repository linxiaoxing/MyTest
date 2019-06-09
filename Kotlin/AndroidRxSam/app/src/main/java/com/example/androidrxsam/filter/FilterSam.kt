package com.example.androidrxsam.filter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class FilterSam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建一个被观察者，发射"1","2","3","4","5", 并过滤出等于1的数据
        val observable = createObservable()
        // 创建一个观察者，接收字符串数组
        val observer = createObserver()
        // 建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    private fun createObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
            .filter {
                it == "1"
            }
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
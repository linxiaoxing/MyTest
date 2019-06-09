package com.example.androidrxsam.take

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

//internal操作符
//使用internal操作符实现Timer的效果，internal操作传入三个参数：
//initialDelay ： 延迟多长时间开始
//period ： 间隔多长时间
//unit ： 时间单位

//take操作符可以用来指定internal操作执行多少次 表示间隔1s发射数据，发射10次，也就是依次发射0~9的数据

class TakeSam : AppCompatActivity() {

    private var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，间隔1秒发射数据
        val observable = createObservable()
        //创建一个观察者，接收数据
        val observer = createObserver()
        //建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    }

    private fun createObservable(): Observable<Long> {
         return Observable.interval(0, 1, TimeUnit.SECONDS)
             .take(10)
    }

    private fun createObserver(): Observer<Long> {
        return object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
                disposable = d
            }

            override fun onNext(data: Long) {
                text.append("$data\n")
                if (data >= 9) {
                    disposable?.dispose()
                    onComplete()
                }
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
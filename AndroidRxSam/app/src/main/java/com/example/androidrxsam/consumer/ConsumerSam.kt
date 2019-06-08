package com.example.androidrxsam.consumer

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

// 大多数时候，我们只关心onNext回调，使用observer每次都需要重写四个回调确实比较麻烦，
// Consumer（意思是消费者）只提供一个回调onNext，效果和observer中的onNext效果一样，
// 如果你不需要关心onError，onComplete，onSubscribe三个回调，可以使用Consumer

@SuppressLint("CheckResult")
class ConsumerSam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，间隔1秒发射数据
        val observable = createObservable()
        //建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Consumer<Long> {
                override fun accept(t: Long) {
                    text.append("$t\n")
                }
            })

        // Kotlin对单方法、单参数的函数提供了一个语法糖，只需要使用it就能代表此参数，所以可以将Consumer进一步简化
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                text.append("$it\n")
            }
    }

    private fun createObservable(): Observable<Long> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
            .take(10)
    }
}
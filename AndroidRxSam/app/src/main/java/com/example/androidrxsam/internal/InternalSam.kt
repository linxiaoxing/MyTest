package com.example.androidrxsam.internal

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

//代码中可以看出，onSubscribe中的Disposable代表建立的订阅，需要取消订阅时，使用disposable.dispose方法即可。如果不取消订阅，internal的onNext回调将一直执行，直到当前程序进程被杀死。
//由此可以看出，RxJava使用时一定要及时关闭订阅，否则会导致内存泄漏问题，有一个比较方便的框架RxLifecycle，可以帮助我们在Activity生命周期中关闭订阅。
//使用internal操作后，线程会切到子线程。如果使用internal发射数据后需要更新UI，请务必记住要切换到主线程

class InternalSam : AppCompatActivity() {

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
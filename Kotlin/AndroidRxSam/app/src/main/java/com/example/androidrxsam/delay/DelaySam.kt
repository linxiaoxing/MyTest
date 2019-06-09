package com.example.androidrxsam.delay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

//delay操作使得被观察者延迟发射数据。
//和internal操作符一样，使用delay操作后，线程也会切到子线程。如果使用delay发射数据后需要更新UI，请务必记住要切换到主线程。

class DelaySam : AppCompatActivity() {

    private var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者
        val observable = createObservable()
        //创建一个观察者，接收数据
        val observer = createObserver()
        //建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    }

    private fun createObservable(): Observable<String> {
         return Observable.just("1", "2", "3")
             .delay(1, TimeUnit.SECONDS)
    }

    private fun createObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(str: Disposable) {
                text.append("subscribe\n")
                disposable = str
            }

            override fun onNext(data: String) {
                text.append("$data\n")
                disposable?.dispose()
                onComplete()
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
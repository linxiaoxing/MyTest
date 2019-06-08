package com.example.androidrxsam.map

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

//注：map()函数中需要传入一个Function<T1,T2>进行类型转换，Function中需要重写apply函数，这里同样使用了kotlin的语法糖，it表示传进来的整数，map函数最后一行作为返回值
//
//T2 apply(T1 data)：将T1类型的数据传入，返回T2类型数据，实现数据类型转换

class MapSample: AppCompatActivity() {

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
            .map{
                "string $it"
            }
            .subscribe(observer)
    }

    private fun createObservable(): Observable<Int> {
        return Observable.create {
            for (i in 0..9) {
                //通知观察者执行onNext()方法
                it.onNext(i)
            }
            //通知观察者数据发送完成
            it.onComplete()
        }
    }

    private fun createObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
            }

            override fun onNext(string: String) {
                text.append("$string\n")
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
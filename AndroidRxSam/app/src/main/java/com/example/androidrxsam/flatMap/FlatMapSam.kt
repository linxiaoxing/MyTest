package com.example.androidrxsam.flatMap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

// 上面的代码原始发射数据是0~9的一列数字，flatMap传入一个原始数据，输出一个被观察者，也就是将单个数字单独用一个被观察者发射出去。执行以上程序
// flatMap有个类似的方法concatMap，使用上没有差别，区别在于flatMap展开后是无序的，concatMap展开后是有序的，使用concatMap的话，展开的一列被观察者将会按照原始数据的顺序依次发射
class FlatMapSam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，发出整型数据
        val observable = createObservable()
        //创建一个观察者，接收字符串数据
        val observer = createObserver()

        //建立订阅
        observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { origin ->
                Observable.create<String> {
                    //将原始的一列数据展开，单独用一个被观察者发射出去
                    it.onNext("new emitter:$origin")
                    //当展开的所有被观察者都完成后，原始被观察者才会完成
                    it.onComplete()
                }
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
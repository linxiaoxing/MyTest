package com.example.androidrxsam.buffer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
// buffer的意思是缓冲，buffer(count)是指收集到count个结果后，再一起传给Observer
// 使用buffer操作符，Observer中收到的数据是一个列表，如果订阅结束，数据不足三个，剩余数据列表也会传到Observer中

class BufferSam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建一个被观察者，发射"1","2","3","4","5", 并缓冲3次
        val observable = createObservable()
        // 创建一个观察者，接收字符串数组
        val observer = createObserver()
        // 建立订阅
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    private fun createObservable(): Observable<List<String>> {
        return Observable.just("1", "2", "3", "4", "5")
            .buffer(3)
    }

    private fun createObserver(): Observer<List<String>> {
        return object : Observer<List<String>> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
            }

            override fun onNext(data: List<String>) {
                text.append("收到了buffer 3次的数据\n")
                data.forEach {
                    text.append("$it\n")
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
package com.example.androidrxsam.rxLifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.androidrxsam.R
import com.trello.rxlifecycle3.RxLifecycle.bindUntilEvent
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

//简介
//使用RxJava时，在界面关闭后，如果订阅未执行完，订阅不会自动停止。需要手动取消订阅。使用RxLifecycle可以在建立订阅时就指定在Activity 的onDestroy中（或者或者Fragment的onDestroyView中）取消订阅，省去了自己手动取消订阅的步骤。
//
//RxLifecycle的Github地址为：https://github.com/trello/RxLifecycle
//
//使用
//1.在build.gradle中导入RxLifecycle
//
//implementation 'com.trello.rxlifecycle3:rxlifecycle-components:3.0.0'
//1
//注：RxLifecycle中包含了RxJava包，所以导入了RxLifecycle之后就可以不用导入RxJava了，但是RxLifecycle不包含RxAndroid，所以还是需要导入RxAndroid

// 在Activity已经onDestroy之后，RxJava的internal订阅仍在运行，这就是内存泄漏了

class RxLifecycleSam : RxAppCompatActivity() {
    // 首先将继承类由AppCompatActivity改为RxAppCompatActivity，这是使用RxLifecycle必需的，
    // 然后建立订阅时加入.compose(bindUntilEvent(ActivityEvent.DESTROY))即可，
    // 这行代码需要加在subscribe(observer)调用之前

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建一个被观察者，间隔1秒发射数据
        val observable = createObservable()
        //创建一个观察者，接收数据
        val observer = createObserver()
        //建立订阅
        observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(bindUntilEvent(ActivityEvent.DESTROY))
            .subscribe(observer)
    }


    private fun createObservable(): Observable<Long> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)

    }

    private fun createObserver(): Observer<Long> {
        return object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                text.append("subscribe\n")
                Log.d(TAG, "onSubscribe")
            }

            override fun onNext(data: Long) {
                text.append("$data\n")
                Log.d(TAG, "$data")
            }

            override fun onComplete() {
                text.append("complete.")
                Log.d(TAG, "onComplete")
            }

            override fun onError(e: Throwable) {
                text.append(e.message)
                Log.d(TAG, "onError")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
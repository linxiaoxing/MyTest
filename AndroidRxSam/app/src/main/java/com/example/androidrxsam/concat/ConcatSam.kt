package com.example.androidrxsam.concat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

//concat操作符和merge操作符很像，只是concat操作符是按照顺序执行的。merge和concat的关系类似flatMap和concatMap的关系。
//将之前的代码中的merge替换为concat：
// 可以看出，在concat中是严格按照传入的顺序，先执行observable1，再执行observable2。虽然observable1延迟了一秒执行，observable2仍然是按照顺序，等待observable1完成后才执行
class ConcatSam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建第一个被观察者，延迟1秒发射"1","2","3","4","5"
        val observable1 = createObservable1()
        // 创建第二个被观察者，发射"a","b","c"
        val observable2 = createObservable2()
        // 创建一个观察者，接收字符串数据
        val observer = createObserver()
        // 建立订阅，使用concat操作将两个被观察者发射的数据合并发射
        Observable.concat(observable1, observable2)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

        // 建立订阅，使用concatWith操作添加第二个被观察者
        observable1.concatWith(observable2)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    private fun createObservable1(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
            .delay(1, TimeUnit.SECONDS)
    }

    private fun createObservable2(): Observable<String> {
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

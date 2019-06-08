package com.example.androidrxsam.zip

import android.arch.core.util.Function
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_main.*
// zip操作将两个被观察者发射的数据合并为一个数据发射
//zip操作接收三个参数，分别是第一个被观察者observable1、第二个被观察者observable1、结合方式BiFunction。
//BiFunction中有三个参数类型，分别代表observable1发射的数据类型，observable2发射的数据类型，数据合并后发射的数据类型。
//BiFunction中的apply函数代表合并的方式。
//本例中，observable1发射Long类型数据，observable2发射String类型数据，在apply中的结合方式为

//zip操作会随着其中任何一个Observable终止而终止，也就是说，如果本例中将observable1的参数改为发射4个整数：
//
//private fun createObservable1(): Observable<Long> {
//    return Observable.just(1, 2, 3, 4)
//}
//observable2不变，仍然发射三个字符"a",“b”,“c”，运行结果仍然和上图一样。因为当observable1终止时，zip操作也就终止了，不会再接收observable2的数据

class ZipSam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建第一个被观察者，发射1，2，3
        val observable1 = createObservable1()
        // 创建第二个被观察者，发射"a","b","c"
        val observable2 = createObservable2()
        // 创建一个观察者，接收字符串数据
        val observer = createObserver()
        // 建立订阅，使用zip操作将两个被观察者发射的数据组合成一个数据
        Observable.zip(observable1, observable2, object : BiFunction<Long, String, String> {
            override fun apply(t1: Long, t2: String): String {
                return t1.toString() + t2
            }
        }).subscribe(observer)

        // zipWith操作符
        // zipWith和zip的作用是一样的，不同之处是zip操作传入两个被观察者，zipWith是一个被观察者加上另一个被观察者
        // 建立订阅，使用zipWith添加第二个被观察者
        observable1.zipWith(observable2, object : BiFunction<Long, String, String> {
            override fun apply(t1: Long, t2: String): String {
                return t1.toString() + t2
            }
        }).subscribe(observer)
    }

    private fun createObservable1(): Observable<Long> {
         return Observable.just(1, 2, 3)
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
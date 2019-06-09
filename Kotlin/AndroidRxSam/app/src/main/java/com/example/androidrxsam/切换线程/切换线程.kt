package com.example.androidrxsam.切换线程

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidrxsam.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("CheckResult")
//subscribeOn指定其之前的代码所在的线程，直到遇到另一个subscribeOn。
//observeOn指定其之后的代码所在的线程，直到遇到另一个observeOn。

class 切换线程: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 建立订阅
        Observable.just(1,2,3)
            // subscribeOn指定其之前的代码所在的线程，所以just操作在新线程中执行
            .subscribeOn(Schedulers.newThread())
            .doOnSubscribe {
                text.append("在主线程中执行:doOnSubscribe\n")
            }
            // subscribeOn指定其之前的代码所在的线程，所以doOnSubscribe在主线程执行
            .subscribeOn(AndroidSchedulers.mainThread())
            // observeOn指定其之后的代码所在的线程，所以map操作在新线程中执行
            .observeOn(Schedulers.newThread())
            .map {
                "在新线程中将其转化成了string$it"
            }
            // observeOn指定其之后的代码所在的线程，所以subscribe操作在主线程中执行
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                text.append("在主线程中执行:$it\n")
            }
    }
}
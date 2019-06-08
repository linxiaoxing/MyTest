package com.example.androidrxsam.retry

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class RetrySam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 当执行onError后，重新发起订阅。直接使用retry()会无限重试，所以我们一般使用retry(n)重试n次
        var count = 1
        Observable.just("a")
            .map {
                Log.d("~~~", "第${count++}次map")
                // onError
                it.toInt()
            }
            .retry(2)
            .subscribe({
                text.append(it.toString())
            }, {
                text.append(it.toString())
            })

        // 当执行onComplete后，重新发起订阅。repeat和retry很相似，直接使用repeat()会无限重试，所以我们一般使用repeat(n)重复n次
        var count2 = 1
        Observable.just("1")
            .map {
                Log.d("~~~", "第${count2++}次map")
                it.toInt()
            }
            .repeat(2)
            .subscribe()

        // repeatWhen: 当订阅将要走onComplete时，如果满足一定条件，就拷贝一个当前订阅并重复
        var a = 10
        Observable.just(a)
            .repeatWhen {
                it.takeUntil {
                    a <= 5
                }
            }
            .subscribe({
                Log.d("~~~", "onNext:it = $it, a = $a")
                a--
            }, {
                Log.d("~~~", "onError:$it")
            }, {
                Log.d("~~~", "onComplete")
            }, {
                Log.d("~~~", "onSubscribe")
            })

        // retryWhen: 当订阅将要走onError时，如果满足一定条件，就重试
        var retryCount = 0
        Observable.just("a")
            .map {
                it.toInt()
            }
            .retryWhen {
                it.flatMap { error ->
                    if (retryCount++ < 5) {
                        Log.d("~~~", "收到错误:$error,开始第${retryCount}次重试")
                        Observable.timer(1, TimeUnit.SECONDS)
                    } else {
                        Observable.error(Throwable("重试结束"))
                    }
                }
            }
            .subscribe({
                Log.d("~~~", "onNext")
            }, {
                Log.d("~~~", "onError:error = $it, a = $retryCount")
            }, {
                Log.d("~~~", "onComplete")
            }, {
                Log.d("~~~", "onSubscribe")
            })
    }
}
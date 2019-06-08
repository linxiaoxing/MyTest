package com.example.androidrxsam.error

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.activity_main.*

class ErrorSam: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 要走onError的时候将其拦截，返回新值
        onErrorReturn()

        // 要走onError的时候将其拦截，返回新的被观察者
        onErrorResumeNext()

        error()

        errorOnError()

        empty()
    }

    private fun onErrorReturn() {
        Observable.just("a")
            .map {
                it.toInt()
            }
            .onErrorReturn {
                text.append("$it\n")
                -1
            }
            .subscribe {
                text.append(it.toString())
            }

    }

    private fun onErrorResumeNext() {
        Observable.just("a")
            .map {
                it.toInt()
            }
            .onErrorResumeNext(Function {
                text.append("$it\n")
                Observable.just(-1)
            })
            .subscribe {
                text.append(it.toString())
            }

    }

    /* 使用error操作符，发送一个异常到观察者 */
    private fun error() {
        Observable.error<Int>(Exception())
            .subscribe({
                // it表示正常流程下的Int数据，这里不会执行
                text.append(it.toString())
            }, {
                // it表示异常信息
                text.append(it.toString())
            })
    }

    /* error和onErrorResumeNext结合使用 同时使用error和onErrorResumeNext，可以在即将走onError的时候，将错误信息拦截，并返回我们自己的自定义异常 */
    private fun errorOnError() {
        class MyException(private val throwable: Throwable) : Exception() {
            override val message: String?
                get() = if (throwable is NumberFormatException) {
                    "数字格式不正确"
                } else {
                    super.message
                }
        }
    }

    /* empty 使用empty操作符建立一个特殊的订阅，仅执行onStart和onComplete */
    private fun empty() {
        Observable.empty<Int>()
            .subscribe({
                text.append("onNext:$it\n")
            }, {
                text.append("onError:$it\n")
            }, {
                text.append("onComplete\n")
            }, {
                text.append("onStart\n")
            })
    }
}
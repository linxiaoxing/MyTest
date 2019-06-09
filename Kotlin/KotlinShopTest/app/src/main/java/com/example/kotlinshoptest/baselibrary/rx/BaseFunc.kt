package com.example.kotlinshoptest.baselibrary.rx

import com.example.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        } else {
            return Observable.just(t.data)
        }
    }
}
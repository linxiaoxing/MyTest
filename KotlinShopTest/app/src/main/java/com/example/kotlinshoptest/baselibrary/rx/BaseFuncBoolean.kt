package com.example.kotlinshoptest.baselibrary.rx

import com.example.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1
import com.example.kotlinshoptest.baselibrary.common.ResultCode.Companion.SUCCESS

class BaseFuncBoolean <T> : Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        } else {
            return Observable.just(true)
        }
    }
}
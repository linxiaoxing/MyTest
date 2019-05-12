package com.example.chen.baselibrary.rx

import com.example.chen.baselibrary.common.ResultCode.Companion.SUCCESS
import com.example.chen.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

class BaseFuncBoolean <T> : Func1<BaseResp<T>, Observable<Boolean>>{
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        } else {
            return Observable.just(true)
        }
    }
}
package com.example.wankotlin.http.exception

import java.lang.RuntimeException

class ApiException: RuntimeException {

    private var code: Int? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))

}
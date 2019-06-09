package com.example.wankotlin.rx

import com.example.wankotlin.rx.scheduler.IoMainScheduler

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}
package com.example.gsygithubappkotlin.module.service

import android.app.Service
import android.content.Intent
import android.icu.util.TimeUnit
import android.os.IBinder
import com.aidl.gsygithubappkotlin.ILocalMessage
import com.aidl.gsygithubappkotlin.ILocalMessageCallBack
import com.example.gsygithubappkotlin.common.utils.Debuger
import com.aidl.gsygithubappkotlin.model.AIDLResultModel
import java.util.*
import java.util.concurrent.Executors.newScheduledThreadPool

class LocalAIDLTransferService : Service() {

    private val pool = newScheduledThreadPool(4)

    private var resultCallBack: ILocalMessageCallBack? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Debuger.printfLog("LocalAIDLTransferService onStartCommand " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Debuger.printfLog("LocalAIDLTransferService onCreate " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
    }

    override fun onBind(intent: Intent?): IBinder? {
        Debuger.printfLog("LocalAIDLTransferService onBind " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        pool.scheduleAtFixedRate(runnable, 0, 4,java.util.concurrent.TimeUnit.SECONDS)
        return binder
    }


    override fun onDestroy() {
        super.onDestroy()
        pool.shutdown()
    }

    private val binder = object : ILocalMessage.Stub() {
        override fun sendMessage(message: String?) {
            Debuger.printfLog("LocalAIDLTransferService sendMessage $message " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        }

        override fun getVersion(): Int {
            return 1
        }

        override fun registerCallBack(callback: ILocalMessageCallBack?) {
            resultCallBack = callback
        }
    }

    private val runnable = Runnable {
        Debuger.printfLog("LocalAIDLTransferService send Result pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        val result = AIDLResultModel()
        result.name = "Name " + UUID.randomUUID()
        result.time = Date().time
        resultCallBack?.sendResult(result)
    }
}
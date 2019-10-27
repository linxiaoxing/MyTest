package com.example.gsygithubappkotlin.module.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.*
import com.example.gsygithubappkotlin.common.utils.Debuger

class LocalMessengerService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Debuger.printfLog("LocalMessengerService onStartCommand " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Debuger.printfLog("LocalMessengerService onCreate " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
    }

    override fun onBind(intent: Intent?): IBinder? {
        Debuger.printfLog("LocalMessengerService onBind " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        return messenger.binder
    }

    @SuppressLint("HandlerLeak")
    private val messenger =  Messenger( object :Handler() {
        override fun handleMessage(msg: Message?) {
            val msgToClient = Message.obtain(msg)//to LocalService
            Debuger.printfLog("LocalMessengerService handleMessage " + msg!!.arg1 + " pid" + Process.myPid() + " " + Thread.currentThread())
            when(msg.what) {
                0 -> {
                    Thread.sleep(2000)
                    msgToClient.arg1 = msg.arg1 + msg.arg2
                    msg.replyTo.send(msgToClient)
                    Debuger.printfLog("LocalMessengerService send Messenger " + msgToClient.arg1 + " pid" + Process.myPid() + " " + Thread.currentThread())
                }
            }
            super.handleMessage(msg)
        }
    })
}
package com.example.gsygithubappkotlin.module.service

import android.app.Service
import android.content.Intent
import android.os.Messenger

/**
 * Created by guoshuyu
 */
class LocalService : Service() {

    private var serviceMessenger: Messenger? = null
    private var currentMessenger:Messenger? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Debuger.printfLog("LocalService onStartCommand  " + " pid" + android.os.Process.myPid() + " " + Thread.currentThread())
        bindService(Intent(this, LocalAIDLTransferService::class.java), connectionAidlService, BIND_AUTO_CREATE)
        bindService(Intent(this, LocalMessengerService::class.java), connectionMessengerService, BIND_AUTO_CREATE)
        return START_STICKY
    }

}
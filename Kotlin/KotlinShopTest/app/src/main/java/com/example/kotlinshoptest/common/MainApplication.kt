package com.example.kotlinshoptest.common

import android.util.Log
import com.example.baselibrary.common.BaseApplication
import com.google.firebase.iid.FirebaseInstanceId
import io.realm.Realm
import io.realm.RealmConfiguration

class MainApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        // push通知のトークン取得
        val pushToken = FirebaseInstanceId.getInstance().instanceId
        pushToken.addOnSuccessListener { instanceId ->
            val token = instanceId.token
            Log.d("test:","push token：$token")
            // サーバにトークンを送信する処理など

        }

        //Realmの初期化
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
}
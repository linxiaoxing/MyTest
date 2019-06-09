package com.example.kotlinshoptest.messagecenter.receiver

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.common.HOME_BANNER_ONE
import com.example.kotlinshoptest.messagecenter.data.protocol.Message
import com.example.kotlinshoptest.ui.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import io.realm.Realm
import java.util.*



class SampleListenerService: FirebaseMessagingService() {
    private val TAG = javaClass.simpleName

    private val PRIORITY_MAX = 3

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
        Log.d(TAG, "onNewToken token:$p0")
        // サーバにトークンを送信する処理を書く

        // channelidを設定
        addChannelId()
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        super.onMessageReceived(message)
        Log.d(TAG, "onMessageReceived token:${message?.data}")

        // Check if message contains a data payload.
        message?.data?.isNotEmpty()?.let {
            Log.d(TAG, "Message data payload: " + message.data)
        }

        // Check if message contains a notification payload.
        message?.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.title}")
            Log.d(TAG, "Message Notification Body: ${it.body}")
            // jsonからタイトルと本文を取得
            val title = it.title.toString()
            val text = it.title.toString()
            // 通知エリア表示設定
            sendNotification(title,text)

            //initしたインスタンスをとってきて、トランザクションで書き込み
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction {
                var obj = realm.createObject(Message::class.java!!)
                obj.msgIcon = HOME_BANNER_ONE
                obj.msgTime = "2019/06/01"
                obj.msgTitle = title
                obj.msgContent = text
            }
        }


    }

    private fun sendNotification(title: String, text: String) {
        // 通知エリアから遷移する際のアクティビティを指定
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        // 一度だけ遷移する
        val pendingIntent = PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_ONE_SHOT)

        // 通知メッセージのスタイルを設定（改行表示に対応）
        val inboxStyle = NotificationCompat.InboxStyle()
        val messageArray = text.split("\n")
        for (msg in messageArray) {
            inboxStyle.addLine(msg)
        }

        // 通知音を設定
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // 通知を作成
        val notificationBuilder
                = NotificationCompat.Builder(this,resources.getString(com.example.kotlinshoptest.R.string.channel_id))
                .setContentTitle(title)
                .setContentText(text)
                // ステータスバーに表示されるアイコン
                .setSmallIcon(com.example.kotlinshoptest.R.mipmap.ic_launcher)
                // 通知エリアに表示されるアイコン
                .setLargeIcon(BitmapFactory.decodeResource(resources, com.example.kotlinshoptest.R.mipmap.ic_launcher))
                // 上で設定したpendingIntentを設定
                .setContentIntent(pendingIntent)
                // メッセージを纏める時に表示するテキスト
                .setStyle(inboxStyle.setSummaryText("more"))
                // タップしたら自動で閉じるようにする
                .setAutoCancel(true)
                // 優先度を最大
                .setPriority(PRIORITY_MAX)
                // 音を出す
                .setSound(defaultSoundUri)


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 通知エリアに複数表示させるためランダムのIDを設定
        val uuid = UUID.randomUUID().hashCode()
        notificationManager.notify(uuid, notificationBuilder.build())

        // Android 8(Oreo)以上はチャンネルを指定
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationBuilder.setChannelId(resources.getString(com.example.kotlinshoptest.R.string.channel_id))
        }
    }

    //Android 8(Oreo)以上はチャンネルを設定しないと通知エリアに表示されないためchannelidを設定
    private fun addChannelId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // ヘッドアップ通知を出す場合はチャンネルの重要度も最大にする
            val channel = NotificationChannel(resources.getString(com.example.kotlinshoptest.R.string.channel_id),resources.getString(com.example.kotlinshoptest.R.string.channel_name),NotificationManager.IMPORTANCE_HIGH)

            // ロック画面での表示レベル
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            // チャンネル登録
            manager.createNotificationChannel(channel)
        }
    }
}
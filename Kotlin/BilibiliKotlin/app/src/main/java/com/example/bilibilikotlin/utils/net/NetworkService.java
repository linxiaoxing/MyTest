package com.example.bilibilikotlin.utils.net;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;

/**
 * 网络状态监听服务
 */
public class NetworkService extends Service {

    private final static int GRAY_SERVICE_ID = 1001;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                networkBroadCast(context, intent, -1);
                return;
            }
        }
    };

    private void networkBroadCast(Context context, Intent intent, int netState) {
        intent.setAction(NetworkUtils.NET_BROADCAST_ACTION);
        intent.putExtra(NetworkUtils.NET_STATE_NAME, netState);
        context.sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}

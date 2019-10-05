package com.didi365.dlnasupport.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.didi365.dlnasupport.center.MediaControlBrocastFactory;
import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.LogFactory;

public class VideoPlayerService extends Service implements MediaControlBrocastFactory.IMediaControlListener,
        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener {

    private static final CommonLog log = LogFactory.createLog("VideoPlayerService");

    @Override
    public void onCreate() {
        super.onCreate();
        log.v("onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log.v("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        log.v("onBufferingUpdate");
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        log.v("onError");
        return false;
    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        log.v("onSeekComplete");
    }

    @Override
    public void onPlayCommand() {
        log.v("onPlayCommand");
    }

    @Override
    public void onPauseCommand() {
        log.v("onPauseCommand");
    }

    @Override
    public void onStopCommand() {
        log.v("onStopCommand");
    }

    @Override
    public void onSeekCommand(int time) {
        log.v("onSeekCommand " + time);
    }

}

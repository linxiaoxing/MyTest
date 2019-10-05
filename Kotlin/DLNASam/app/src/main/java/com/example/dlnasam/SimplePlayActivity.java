package com.example.dlnasam;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.baidu.cloud.media.player.IMediaPlayer;
import com.didi365.dlnasupport.center.DLNAGenaEventBrocastFactory;
import com.didi365.dlnasupport.center.DlnaMediaModel;
import com.didi365.dlnasupport.center.DlnaMediaModelFactory;
import com.didi365.dlnasupport.center.MediaControlBrocastFactory;
import com.example.dlnasam.widget.BDCloudVideoView;

import java.util.Timer;
import java.util.TimerTask;

public class SimplePlayActivity extends Activity implements IMediaPlayer.OnPreparedListener,
        IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener,
        IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener,
        BDCloudVideoView.OnPlayerStateListener, MediaControlBrocastFactory.IMediaControlListener {

    private static final String TAG = "SimplePlayActivity";

    private DlnaMediaModel mMediaInfo;
    private BDCloudVideoView mVV = null;
    private MediaController mediaController = null;
    private RelativeLayout mViewHolder = null;
    private MediaControlBrocastFactory mMediaControlBorcastFactory;

    private Timer barTimer;

    private String ak = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_simple_video_playing);
        PowerManager pm = (PowerManager) getSystemService( Context.POWER_SERVICE);

        mMediaInfo = DlnaMediaModelFactory.createFromIntent(getIntent());
        initUI();
    }

    /**
     * 初始化界面
     */
    private void initUI() {
        mViewHolder = findViewById(R.id.view_holder);
        mediaController = findViewById(R.id.media_controller_bar);
        /**
         * 设置ak
         */
        BDCloudVideoView.setAK(ak);

        mVV = new BDCloudVideoView(this);
        mVV.setVideoPath(mMediaInfo.getUrl());
        mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);

        RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(-1, -1);
        rllp.addRule(RelativeLayout.CENTER_IN_PARENT);
        mViewHolder.addView(mVV, rllp);

        /**
         * 注册listener
         */
        mVV.setOnPreparedListener(this);
        mVV.setOnCompletionListener(this);
        mVV.setOnErrorListener(this);
        mVV.setOnInfoListener(this);
        mVV.setOnBufferingUpdateListener(this);
        mVV.setOnPlayerStateListener(this);

        mediaController.setMediaPlayerControl(mVV);

        mVV.start();

        mMediaControlBorcastFactory = new MediaControlBrocastFactory(this);
        mMediaControlBorcastFactory.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart");
        if (mVV != null) {
            mVV.enterForeground();
        }
    }

    @Override
    protected void onStop() {
        Log.v(TAG, "onStop");
        if (mVV != null) {
            mVV.enterBackground();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVV != null) {
            mVV.stopPlayback();
            DLNAGenaEventBrocastFactory.sendStopStateEvent(this);
        }
        Log.v(TAG, "onDestroy");
    }

    /**
     * 检测'点击'空白区的事件，若播放控制控件未显示，设置为显示，否则隐藏。
     *
     * @param v
     */
    public void onClickEmptyArea(View v) {
        if (barTimer != null) {
            barTimer.cancel();
            barTimer = null;
        }
        if (this.mediaController != null) {
            if (mediaController.getVisibility() == View.VISIBLE) {
                mediaController.hide();
            } else {
                mediaController.show();
                hideOuterAfterFiveSeconds();
            }
        }
    }

    private void hideOuterAfterFiveSeconds() {
        if (barTimer != null) {
            barTimer.cancel();
            barTimer = null;
        }
        barTimer = new Timer();
        barTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (mediaController != null) {
                    mediaController.getMainThreadHandler().post(new Runnable() {

                        @Override
                        public void run() {
                            mediaController.hide();
                        }

                    });
                }
            }

        }, 5 * 1000);

    }

    @Override
    public boolean onInfo(IMediaPlayer mp, int what, int extra) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onError(IMediaPlayer mp, int what, int extra) {
        // restart player?

        return false;
    }

    @Override
    public void onCompletion(IMediaPlayer mp) {
    }

    @Override
    public void onPrepared(IMediaPlayer mp) {
    }

    @Override
    public void onBufferingUpdate(IMediaPlayer mp, int percent) {
        if (mediaController != null && mVV != null) {
            mediaController.onTotalCacheUpdate(percent * mVV.getDuration() / 100);
        }
    }

    @Override
    public void onPlayerStateChanged(BDCloudVideoView.PlayerState nowState) {
        if (mediaController != null) {
            mediaController.changeState();
        }
    }

    @Override
    public void onPlayCommand() {
        if (mediaController != null) {
            mediaController.play();
        }
    }

    @Override
    public void onPauseCommand() {
        if (mediaController != null) {
            mediaController.pause();
        }
    }

    @Override
    public void onStopCommand() {
        finish();
    }

    @Override
    public void onSeekCommand(int time) {
        if (mediaController != null) {
            mediaController.seek(time);
        }
    }
}

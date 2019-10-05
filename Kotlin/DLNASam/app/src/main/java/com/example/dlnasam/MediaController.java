package com.example.dlnasam;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.didi365.dlnasupport.center.DLNAGenaEventBrocastFactory;
import com.didi365.dlnasupport.center.MediaControlBrocastFactory;
import com.example.dlnasam.widget.BDCloudVideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MediaController extends RelativeLayout implements MediaControlBrocastFactory.IMediaControlListener{

    private static final String TAG = "SimpleMediaController";

    private ImageButton playButton;
    private TextView positionView;
    private SeekBar seekBar;
    private TextView durationView;

    private Context mContext;

    private Timer positionTimer;
    private static final int POSITION_REFRESH_TIME = 500;

    private Handler mainThreadHandler = new Handler( Looper.getMainLooper());

    public Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    private BDCloudVideoView mVideoView = null;

    boolean mbIsDragging = false;

    private MediaControlBrocastFactory mMediaControlBorcastFactory;

    public MediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initUI();
    }

    public MediaController(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public void play() {
        if (mVideoView != null) {
            mVideoView.start();
        }
    }

    public void pause() {
        if (mVideoView != null) {
            mVideoView.pause();
        }
    }

    public void seek(int position) {
        Log.d(TAG, "seek " + position);
        if (mVideoView != null) {
            mVideoView.seekTo(position);
        }
    }

    private void initUI() {
        // inflate controller bar
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.bar_simple_media_controller, this);

        playButton = (ImageButton) layout.findViewById(R.id.btn_play);
        playButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mVideoView == null) {
                    Log.d(TAG, "playButton checkstatus changed, but bindView=null");
                } else {
                    if (mVideoView.isPlaying()) {
                        Log.d(TAG, "playButton: Will invoke pause()");
                        playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                        mVideoView.pause();
                    } else {
                        Log.d(TAG, "playButton: Will invoke resume()");
                        playButton.setBackgroundResource(R.drawable.toggle_btn_pause);
                        mVideoView.start();
                    }
                }
            }
        });

        positionView = (TextView) layout.findViewById(R.id.tv_position);
        seekBar = (SeekBar) layout.findViewById(R.id.seekbar);
        seekBar.setMax(0);
        durationView = (TextView) layout.findViewById(R.id.tv_duration);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatePostion(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                mbIsDragging = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mVideoView.getDuration() > 0) {
                    // 仅非直播的视频支持拖动
                    currentPositionInMilliSeconds = seekBar.getProgress();
                    if (mVideoView != null) {
                        mVideoView.seekTo(seekBar.getProgress());
                    }
                }
                mbIsDragging = false;
            }
        });
        enableControllerBar(false);

        mMediaControlBorcastFactory = new MediaControlBrocastFactory(mContext);
        mMediaControlBorcastFactory.register(this);
    }

    /**
     *
     */
    public void changeState() {
        final BDCloudVideoView.PlayerState status = mVideoView.getCurrentPlayerState();
        Log.d(TAG, "mediaController: changeStatus=" + status.name());
        isMaxSetted = false;
        mainThreadHandler.post(new Runnable() {

            @Override
            public void run() {
                if (status == BDCloudVideoView.PlayerState.STATE_IDLE || status == BDCloudVideoView.PlayerState.STATE_ERROR) {
                    stopPositionTimer();
                    playButton.setEnabled(true);
                    playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                    seekBar.setEnabled(false);
                    updatePostion(mVideoView == null ? 0 : mVideoView.getCurrentPosition());
                    updateDuration(mVideoView == null ? 0 : mVideoView.getDuration());
                } else if (status == BDCloudVideoView.PlayerState.STATE_PREPARING) {
                    playButton.setEnabled(false);
//                    playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                    seekBar.setEnabled(false);
                } else if (status == BDCloudVideoView.PlayerState.STATE_PREPARED) {
                    playButton.setEnabled(true);
                    playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                    seekBar.setEnabled(true);
                    updateDuration(mVideoView == null ? 0 : mVideoView.getDuration());
                    seekBar.setMax(mVideoView.getDuration());
                    DLNAGenaEventBrocastFactory.sendTranstionEvent(mContext);
                } else if (status == BDCloudVideoView.PlayerState.STATE_PLAYBACK_COMPLETED) {
                    stopPositionTimer();
                    seekBar.setProgress(seekBar.getMax());
                    seekBar.setEnabled(false);
                    playButton.setEnabled(true);
                    playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                    DLNAGenaEventBrocastFactory.sendDurationEvent(mContext, mVideoView.getDuration());
                    play();
                } else if (status == BDCloudVideoView.PlayerState.STATE_PLAYING) {
                    startPositionTimer();
                    seekBar.setEnabled(true);
                    playButton.setEnabled(true);
                    playButton.setBackgroundResource(R.drawable.toggle_btn_pause);
                    DLNAGenaEventBrocastFactory.sendPlayStateEvent(mContext);
                } else if (status == BDCloudVideoView.PlayerState.STATE_PAUSED) {
                    playButton.setEnabled(true);
                    playButton.setBackgroundResource(R.drawable.toggle_btn_play);
                    DLNAGenaEventBrocastFactory.sendPauseStateEvent(mContext);
                }
            }
        });
    }

    private void startPositionTimer() {
        if (positionTimer != null) {
            positionTimer.cancel();
            positionTimer = null;
        }
        positionTimer = new Timer();
        positionTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onPositionUpdate();
                    }
                });
            }

        }, 0, POSITION_REFRESH_TIME);
    }

    private void stopPositionTimer() {
        if (positionTimer != null) {
            positionTimer.cancel();
            positionTimer = null;
        }
    }

    /**
     * BVideoView implements VideoViewControl, so it's a BVideoView object
     * actually
     *
     * @param player
     */
    public void setMediaPlayerControl(BDCloudVideoView player) {
        mVideoView = player;
    }

    /**
     * Show the controller on screen. It will go away automatically after 3
     * seconds of inactivity.
     */
    public void show() {
        if (mVideoView == null) {
            return;
        }

        setProgress((int) currentPositionInMilliSeconds);

        this.setVisibility(View.VISIBLE);
    }

    /**
     * Remove the controller from the screen.
     */
    public void hide() {
        this.setVisibility(View.GONE);
    }

    /**
     * @hide
     */
    public boolean getIsDragging() {
        return mbIsDragging;
    }

    private void updateDuration(int milliSecond) {
        if (durationView != null) {
            durationView.setText(formatMilliSecond(milliSecond));
        }
    }

    private void updatePostion(int milliSecond) {
        if (positionView != null) {
            positionView.setText(formatMilliSecond(milliSecond));
        }
    }

    private String formatMilliSecond(int milliSecond) {
        int second = milliSecond / 1000;
        int hh = second / 3600;
        int mm = second % 3600 / 60;
        int ss = second % 60;
        String strTemp = null;
        if (0 != hh) {
            strTemp = String.format("%02d:%02d:%02d", hh, mm, ss);
        } else {
            strTemp = String.format("%02d:%02d", mm, ss);
        }
        return strTemp;
    }

    private boolean isMaxSetted = false;

    /**
     * Set the max process for the seekBar, usually the lasting milliseconds
     *
     * @hide
     */
    public void setMax(int maxProgress) {
        if (isMaxSetted) {
            return;
        }
        if (seekBar != null) {
            seekBar.setMax(maxProgress);
        }
        updateDuration(maxProgress);
        if (maxProgress > 0) {
            isMaxSetted = true;
        }
    }

    /**
     * in milliseconds
     *
     * @param progress
     * @hide
     */
    public void setProgress(int progress) {
        if (seekBar != null) {
            seekBar.setProgress(progress);
        }
    }

    /**
     * in milliseconds
     *
     * @hide
     */
    public void setCache(int cache) {
        if (seekBar != null && cache != seekBar.getSecondaryProgress()) {
            seekBar.setSecondaryProgress(cache);
        }
    }

    /**
     * @param isEnable
     * @hide
     */
    public void enableControllerBar(boolean isEnable) {
        seekBar.setEnabled(isEnable);
        playButton.setEnabled(isEnable);
    }

    private long currentPositionInMilliSeconds = 0L;

    /**
     * onPositionUpdate is invoked per 500ms
     */

    public boolean onPositionUpdate() {
        if (mVideoView == null) {
            return false;
        }
        long newPositionInMilliSeconds = mVideoView.getCurrentPosition();

        long previousPosition = currentPositionInMilliSeconds;
        if (newPositionInMilliSeconds > 0 && !getIsDragging()) {
            currentPositionInMilliSeconds = newPositionInMilliSeconds;
            DLNAGenaEventBrocastFactory.sendSeekEvent(mContext, (int) currentPositionInMilliSeconds);
        }
        if (getVisibility() != View.VISIBLE) {
            // 如果控制条不可见，则不设置进度
            return false;
        }
        if (!getIsDragging()) {
            int durationInMilliSeconds = mVideoView.getDuration();
            if (durationInMilliSeconds > 0) {
                this.setMax(durationInMilliSeconds);
                // 直播视频的duration为0，此时不设置进度
                if (previousPosition != newPositionInMilliSeconds) {
                    this.setProgress((int) newPositionInMilliSeconds);
                }
            }
        }
        return false;
    }

    /**
     * invoke per 500ms
     *
     * @param milliSeconds
     */
    public void onTotalCacheUpdate(final long milliSeconds) {
        mainThreadHandler.post(new Runnable() {

            @Override
            public void run() {
                setCache((int) milliSeconds);
            }

        });
    }

    @Override
    public void onPlayCommand() {

    }

    @Override
    public void onPauseCommand() {

    }

    @Override
    public void onStopCommand() {

    }

    @Override
    public void onSeekCommand(int time) {

    }
}
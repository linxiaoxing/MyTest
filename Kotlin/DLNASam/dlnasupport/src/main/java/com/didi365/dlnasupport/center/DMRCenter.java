package com.didi365.dlnasupport.center;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.didi365.dlna.jni.PlatinumReflection;
import com.didi365.dlnasupport.RenderApplication;
import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.DlnaUtils;
import com.didi365.dlnasupport.util.LogFactory;

public class DMRCenter implements PlatinumReflection.ActionReflectionListener, IDMRAction {

    private static final CommonLog log = LogFactory.createLog("DMRCenter");

    private Context mContext;

    private DlnaMediaModel mMusicMediaInfo;
    private DlnaMediaModel mVideoMediaInfo;
    private DlnaMediaModel mImageMediaInfo;

    private int mCurMediaInfoType = -1;
    public static final int CUR_MEDIA_TYPE_MUSCI = 0x0001;
    public static final int CUR_MEDIA_TYPE_VIDEO = 0x0002;
    public static final int CUR_MEDIA_TYPE_PICTURE = 0x0003;

    public DMRCenter(Context context) {
        mContext = context;
    }

    @Override
    public synchronized void onActionInvoke(int cmd, String value, String data) {
        switch (cmd) {
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_SET_AV_URL:
                log.e("recv set av url \n");
                onRenderAvTransport(value, data);
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_PLAY:
                log.e("recv play \n");
                onRenderPlay(value, data);
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_PAUSE:
                log.e("recv pause \n");
                onRenderPause(value, data);
                RenderApplication.getRenderApplication().onRenderPause();
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_STOP:
                log.e("recv stop \n");
                onRenderStop(value, data);
                RenderApplication.getRenderApplication().onRenderStop();
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_SEEK:
                log.e("recv seek " + value + " " + data + "\n");
                onRenderSeek(value, data);
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_SETMUTE:
                log.e("recv set mute \n");
                onRenderSetMute(value, data);
                break;
            case PlatinumReflection.MEDIA_RENDER_CTL_MSG_SETVOLUME:
                log.e("recv set volume \n");
                onRenderSetVolume(value, data);
                break;
            default:
                log.e("unrognized cmd!!!");
                break;
        }
    }

    @Override
    public void onRenderAvTransport(String value, String data) {
        if (data == null) {
            log.e("meteData = null!!!");
            return;
        }

        if (value == null || value.length() < 2) {
            log.e("url = " + value + ", it's invalid...");
            return;
        }

        DlnaMediaModel mediaInfo = DlnaMediaModelFactory.createFromMetaData(data);
        mediaInfo.setUrl(value);
        if (DlnaUtils.isAudioItem(mediaInfo)) {
            mMusicMediaInfo = mediaInfo;
            mCurMediaInfoType = CUR_MEDIA_TYPE_MUSCI;
        } else if (DlnaUtils.isVideoItem(mediaInfo)) {
            log.e("get mediaInfo\n");
            log.e("value:" + value + " data:" + data);
            mVideoMediaInfo = mediaInfo;
            mCurMediaInfoType = CUR_MEDIA_TYPE_VIDEO;
            RenderApplication.getRenderApplication().onRenderAvTransport(mediaInfo);
        } else if (DlnaUtils.isImageItem(mediaInfo)) {
            mImageMediaInfo = mediaInfo;
            mCurMediaInfoType = CUR_MEDIA_TYPE_PICTURE;
        } else {
            log.e(mediaInfo.getObjectClass());
        }
    }

    @Override
    public void onRenderPlay(String value, String data) {
        switch (mCurMediaInfoType) {
            case CUR_MEDIA_TYPE_MUSCI:
                log.e("render music\n");
                if (mMusicMediaInfo != null) {
                    delayToPlayMusic(mMusicMediaInfo);
                } else {
                    MediaControlBrocastFactory.sendPlayBrocast(mContext);
                }
                clearState();
                break;
            case CUR_MEDIA_TYPE_VIDEO:
                log.e("render video\n");
                if (mVideoMediaInfo != null) {
                    delayToPlayVideo(mVideoMediaInfo);
                    RenderApplication.getRenderApplication().onRenderPlay(mVideoMediaInfo);
                } else {
                    log.e("sendPlayBrocast\n");
                    RenderApplication.getRenderApplication().onRenderPlay();
                    MediaControlBrocastFactory.sendPlayBrocast(mContext);
                }
                clearState();
                break;
            case CUR_MEDIA_TYPE_PICTURE:
                log.e("render picture\n");
                if (mImageMediaInfo != null) {
                    delayToPlayImage(mImageMediaInfo);
                } else {
                    MediaControlBrocastFactory.sendPlayBrocast(mContext);
                }
                clearState();
                break;
        }
    }

    @Override
    public void onRenderPause(String value, String data) {
        MediaControlBrocastFactory.sendPauseBrocast(mContext);
    }

    @Override
    public void onRenderStop(String value, String data) {
        delayToStop();
        MediaControlBrocastFactory.sendStopBorocast(mContext);
    }

    @Override
    public void onRenderSeek(String value, String data) {
        int seekPos = 0;
        try {
            seekPos = DlnaUtils.parseSeekTime(value, data);
            MediaControlBrocastFactory.sendSeekBrocast(mContext, seekPos);
            RenderApplication.getRenderApplication().onRenderSeek(seekPos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRenderSetMute(String value, String data) {
        RenderApplication.getRenderApplication().onRenderSetMute(value);
//        if ("1".equals(value)) {
//            CommonUtil.setVolumeMute(mContext);
//        } else if ("0".equals(value)) {
//            CommonUtil.setVolumeUnmute(mContext);
//        }
    }

    @Override
    public void onRenderSetVolume(String value, String data) {
        try {
            int volume = Integer.valueOf(value);
            RenderApplication.getRenderApplication().onRenderSetVolume(volume);

//            if (volume < 101) {
//                CommonUtil.setCurrentVolume(volume, mContext);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearState() {
        mMusicMediaInfo = null;
        mVideoMediaInfo = null;
        mImageMediaInfo = null;
    }

    private static final int DELAYTIME = 200;

    private void delayToPlayMusic(DlnaMediaModel mediaInfo) {
        if (mediaInfo != null) {
            log.e("call delayToPlayMusic\n");
            clearDelayMsg();
            Message msg = mHandler.obtainMessage(MSG_START_MUSICPLAY, mediaInfo);
            mHandler.sendMessageDelayed(msg, DELAYTIME);
        }
    }

    private void delayToPlayVideo(DlnaMediaModel mediaInfo) {
        if (mediaInfo != null) {
            log.e("enter delayToPlayVideo\n");
            clearDelayMsg();
            Message msg = mHandler.obtainMessage(MSG_START_VIDOPLAY, mediaInfo);
            mHandler.sendMessageDelayed(msg, DELAYTIME);
        }
    }

    private void delayToPlayImage(DlnaMediaModel mediaInfo) {
        if (mediaInfo != null) {
            log.e("call delayToPlayImage\n");
            clearDelayMsg();
            Message msg = mHandler.obtainMessage(MSG_START_PICPLAY, mediaInfo);
            mHandler.sendMessageDelayed(msg, DELAYTIME);
        }
    }

    private void delayToStop() {
        clearDelayMsg();
        mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SEND_STOPCMD), DELAYTIME);
    }

    private void clearDelayMsg() {
        clearDelayMsg(MSG_START_MUSICPLAY);
        clearDelayMsg(MSG_START_PICPLAY);
        clearDelayMsg(MSG_START_VIDOPLAY);
        clearDelayMsg(MSG_SEND_STOPCMD);
    }

    private void clearDelayMsg(int num) {
        mHandler.removeMessages(num);
    }

    private static final int MSG_START_MUSICPLAY = 0x0001;
    private static final int MSG_START_PICPLAY = 0x0002;
    private static final int MSG_START_VIDOPLAY = 0x0003;
    private static final int MSG_SEND_STOPCMD = 0x0004;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void dispatchMessage(Message msg) {
            try {
                switch (msg.what) {
                    case MSG_START_MUSICPLAY:
                        DlnaMediaModel mediaInfo1 = (DlnaMediaModel) msg.obj;
                        break;
                    case MSG_START_PICPLAY:
                        DlnaMediaModel mediaInfo2 = (DlnaMediaModel) msg.obj;
//                        startPlayPicture(mediaInfo2);
                        break;
                    case MSG_START_VIDOPLAY:
                        DlnaMediaModel mediaInfo3 = (DlnaMediaModel) msg.obj;
                        RenderApplication.getRenderApplication().startPlayVideo(mediaInfo3);
                        break;
                    case MSG_SEND_STOPCMD:
                        MediaControlBrocastFactory.sendStopBorocast(mContext);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.e("DMRCenter transdel msg catch Exception!!! msgID = " + msg.what);
            }
        }
    };

    private void startPlayVideo(DlnaMediaModel mediaInfo) {
        log.e("startPlayVideo " + mediaInfo);
        RenderApplication.getRenderApplication().startPlayVideo(mediaInfo);
    }
}

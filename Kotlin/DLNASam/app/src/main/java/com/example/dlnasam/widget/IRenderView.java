package com.example.dlnasam.widget;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;

import com.baidu.cloud.media.player.IMediaPlayer;

public interface IRenderView {
    int AR_ASPECT_FIT_PARENT = 0; // without clip, 等比例填充，视频的边界小于或等于显示屏边界，可能留有黑边
    int AR_ASPECT_FILL_PARENT = 1; // may clip，等比例填充，视频边界大于等于显示屏边界，不留黑边，一部分视频区域可能在显示屏边界之外
    int AR_ASPECT_WRAP_CONTENT = 2; // 按照视频实际大小播放
    int AR_MATCH_PARENT = 3; // 不按比例，满屏播放
    int AR_16_9_FIT_PARENT = 4; // 16:9, 视频的边界小于或等于显示屏边界，可能留有黑边
    int AR_4_3_FIT_PARENT = 5; // 4:3, 视频的边界小于或等于显示屏边界，可能留有黑边

    View getView();

    boolean shouldWaitForResize();

    void setVideoSize(int videoWidth, int videoHeight);

    void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen);

    void setVideoRotation(int degree);

    void setAspectRatio(int aspectRatio);

    void addRenderCallback(IRenderCallback callback);

    void removeRenderCallback(IRenderCallback callback);

    void release();

    Bitmap getBitmap();

    interface ISurfaceHolder {
        void bindToMediaPlayer(IMediaPlayer mp);
        IRenderView getRenderView();
        Surface openSurface();
    }

    interface IRenderCallback {
        /**
         * @param holder
         * @param width  could be 0
         * @param height could be 0
         */
        void onSurfaceCreated(ISurfaceHolder holder, int width, int height);

        /**
         * @param holder
         * @param format could be 0
         * @param width
         * @param height
         */
        void onSurfaceChanged(ISurfaceHolder holder, int format, int width, int height);

        void onSurfaceDestroyed(ISurfaceHolder holder);
    }
}

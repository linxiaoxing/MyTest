package com.didi365.dlnasupport;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.didi365.dlna.jni.PlatinumJniProxy;
import com.didi365.dlnasupport.center.DlnaMediaModel;
import com.didi365.dlnasupport.center.MediaRenderProxy;
import com.didi365.dlnasupport.center.PlayerEventListener;
import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.DlnaUtils;
import com.didi365.dlnasupport.util.LogFactory;
import com.tendcloud.tenddata.TCAgent;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class RenderApplication implements ItatisticsEvent {

    private static final CommonLog log = LogFactory.createLog("RenderApplication");
    private static Context context;
    private static RenderApplication renderApplication;
    private static DeviceInfo mDeviceInfo;

    private PlayerEventListener playerEventListener;

    private OutputStream outputStream;

    private MediaRenderProxy mRenderProxy = MediaRenderProxy.getInstance();

    private RenderApplication() {
    }

    public static void init(Application application) {
        context = application;
        mDeviceInfo = new DeviceInfo();
        TCAgent.init(context);
        TCAgent.setReportUncaughtExceptions(true);
//        MobclickAgent.setDebugMode(true);
    }

    public static Context getInstance() {
        return context;
    }

    public static RenderApplication getRenderApplication() {
        if (renderApplication == null) {
            renderApplication = new RenderApplication();
        }
        return renderApplication;
    }

    public static void setContext(Context context) {
        RenderApplication.context = context;
    }

    public DeviceInfo getDevInfo() {
        return mDeviceInfo;
    }

    public void updateDevInfo(String name, String uuid) {
        mDeviceInfo.dev_name = name;
        mDeviceInfo.uuid = uuid;
    }

    public void setDevStatus(boolean flag) {
        mDeviceInfo.status = flag;
        DeviceUpdateBrocastFactory.sendDevUpdateBrocast(context);
    }

    public void setDlnaName(String friendname) {
        DlnaUtils.setDevName(getInstance(), friendname);
    }

    public void startEngine() {
        mRenderProxy.startEngine();
    }

    public void resetEngine() {
        mRenderProxy.restartEngine();
    }

    public void stopEngine() {
        mRenderProxy.stopEngine();
    }

    @Override
    public void onEvent(String eventID) {
        log.v("eventID = " + eventID);
        TCAgent.onEvent(context, eventID);
    }

    @Override
    public void onEvent(String eventID, HashMap<String, String> map) {
        log.v("eventID = " + eventID);
        TCAgent.onEvent(context, eventID, "", map);
    }

    public static void onPause(Activity context) {
        MobclickAgent.onResume(context);
        TCAgent.onPause(context);
    }

    public static void onResume(Activity context) {
        MobclickAgent.onResume(context);
        TCAgent.onResume(context);
    }

    public static void onCatchError(Context context) {
        TCAgent.setReportUncaughtExceptions(true);
    }

    public void startPlayVideo(DlnaMediaModel mediaInfo) {
        if (playerEventListener != null) {
            playerEventListener.startPlayVideo(mediaInfo);
        }
    }

    public void sendRenderData(String data) {
        if (getOutputStream() != null) {
            try {
                getOutputStream().write((data + "\r\n").getBytes());
                getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * set av url
     *
     * @param mediaModel
     */
    public void onRenderAvTransport(DlnaMediaModel mediaModel) {
        log.v("onRenderAvTransport " + mediaModel);
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"type\":")
                .append(100)
                .append(",")
                .append("\"action\":")
                .append("\"seturl\"")
                .append(",")
                .append("\"media\":")
                .append(mediaModel.toString())
                .append("}");
        sendRenderData(builder.toString());
    }

    /**
     * play
     *
     * @param mediaModel
     */
    public void onRenderPlay(DlnaMediaModel mediaModel) {
        log.v("onRenderPlay " + mediaModel);
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"type\":")
                .append(100)
                .append(",")
                .append("\"action\":")
                .append("\"play\"")
                .append(",")
                .append("\"media\":")
                .append(mediaModel.toString())
                .append("}");
        sendRenderData(builder.toString());
    }

    public void onRenderPlay() {
        log.v("onRenderPlay");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "play_on");
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * pause
     */
    public void onRenderPause() {
        log.v("onRenderPause");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "pause");
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * stop
     */
    public void onRenderStop() {
        log.v("onRenderStop");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "stop");
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * seek
     *
     * @param seekPos
     */
    public void onRenderSeek(int seekPos) {
        log.v("onRenderSeek " + seekPos);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "seek");
            jsonObject.put("seekPos", seekPos);
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * set volume
     *
     * @param volume
     */
    public void onRenderSetVolume(int volume) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "setvolume");
            jsonObject.put("volume", volume);
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * set mute
     *
     * @param value
     */
    public void onRenderSetMute(String value) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", 100);
            jsonObject.put("action", "setMute");
            jsonObject.put("mute", value);
            sendRenderData(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * response
     *
     * @param cmd
     * @param value
     * @param data
     */
    public void responseGenaEvent(int cmd, String value, String data) {
        PlatinumJniProxy.responseGenaEvent(cmd, value, data);
    }

    public void setPlayerEventListener(PlayerEventListener playerEventListener) {
        this.playerEventListener = playerEventListener;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}

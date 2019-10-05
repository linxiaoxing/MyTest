package com.didi365.dlna.jni;

import android.util.Log;

import java.io.UnsupportedEncodingException;

public class PlatinumJniProxy {

    private static String TAG = "PlatinumJniProxy";

    static {
        System.loadLibrary("platinum-jni");
    }

    public static native int startDlnaMediaRender(byte[] friendname, byte[] uuid);

    public static native void stopDlnaMediaRender();

    public static native boolean responseGenaEvent(int cmd, byte[] value, byte[] data);

    public static int startMediaRender(String friendname, String uuid) {
        if (friendname == null) friendname = "";
        if (uuid == null) uuid = "";
        int ret = -1;
        try {
            ret = startDlnaMediaRender(friendname.getBytes("utf-8"), uuid.getBytes("utf-8"));
            Log.i(TAG, "startMediaRender ret " + ret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static boolean responseGenaEvent(int cmd, String value, String data) {
        Log.i(TAG, "responseGenaEvent cmd:" + cmd + " value:" + value + " data:" + data);
        if (value == null)
            value = "";
        if (data == null)
            data = "";

        boolean ret = false;
        try {
            ret = responseGenaEvent(cmd, value.getBytes("utf-8"), data.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

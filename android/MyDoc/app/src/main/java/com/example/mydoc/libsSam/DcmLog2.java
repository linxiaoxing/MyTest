package com.example.mydoc.libsSam;

import android.util.Log;

public class DcmLog2 {

    public DcmLog2() {
    }

    public static void v(String tag, String msg) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.v(tag, msg);
        }

    }

    public static void v(String tag, String msg, Throwable tr) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.v(tag, msg, tr);
        }

    }

    public static void d(String tag, String msg) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.d(tag, msg);
        }

    }

    public static void d(String tag, String msg, Throwable tr) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.d(tag, msg, tr);
        }

    }

    public static void i(String tag, String msg) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.i(tag, msg);
        }

    }

    public static void i(String tag, String msg, Throwable tr) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.i(tag, msg, tr);
        }

    }

    public static void w(String tag, String msg) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.w(tag, msg);
        }

    }

    public static void w(String tag, String msg, Throwable tr) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.w(tag, msg, tr);
        }

    }

    public static void e(String tag, String msg) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.e(tag, msg);
        }

    }

    public static void e(String tag, String msg, Throwable tr) {
        if (DcmTracker2.dcmTrackLogFlg) {
            Log.e(tag, msg, tr);
        }

    }
}

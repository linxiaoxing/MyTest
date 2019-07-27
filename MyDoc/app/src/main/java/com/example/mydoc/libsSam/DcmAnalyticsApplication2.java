package com.example.mydoc.libsSam;

import android.app.Application;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

public class DcmAnalyticsApplication2 extends Application {
    DcmTracker2 dcmTracker;
    private final String CHAR_CODE = "UTF-8";
    private final int idsite = 0;
    private boolean dcmTrackLogFlg = false;

    public DcmAnalyticsApplication2() {
    }

    public synchronized DcmTracker2 getTracker() {
        if (this.dcmTracker != null) {
            return this.dcmTracker;
        } else {
            if (this.getTrackerUrl().equals("")) {
                DcmLog2.e(DcmTracker2.LOGGER_TAG, "URLを設定してください");
            }

            try {
                this.dcmTracker = new DcmTracker2(this.getTrackerUrl());
                this.dcmTracker.setUserId(this.dcmTracker.getUserId(this.getApplicationContext()));
                dcmTrackLogFlg = this.getDcmTrackLogFlg();
            } catch (MalformedURLException var2) {
                return null;
            }

            return this.dcmTracker;
        }
    }

    public String getTrackerUrl() {
        return "";
    }

    public Integer getSiteId() {
        return 0;
    }

    public String getApplicationUrl() {
        String domain = "http://" + this.getPackageName();

        try {
            return URLEncoder.encode(domain, "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            return domain;
        }
    }

    public boolean getDcmTrackLogFlg() {
        return false;
    }
}

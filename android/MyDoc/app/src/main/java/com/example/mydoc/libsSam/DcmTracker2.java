package com.example.mydoc.libsSam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

public class DcmTracker2 {
    private String userId;
    private final String name = "dcmanalytics";
    private final String uuidKey = "dcmanalyticsuuid";
    private final String authTimeKey = "dcmanalyticsauthtime";
    private String authUrl = "";
    private Long authInterval = 86400000L;
    public static boolean dcmTrackLogFlg = false;
    protected static final String LOGGER_TAG;

    static {
        LOGGER_TAG = DcmTracker2.class.getName().toUpperCase(Locale.ENGLISH);
    }

    public DcmTracker2(String url) throws MalformedURLException {
        this.setAuthUrl(url);
    }

    public void dcmWebAuth(Activity activity) {
        try {
            if (activity != null) {
                if (!this.checkAuth(activity.getApplicationContext())) {
                    return;
                }

                WebView webView = new WebView(activity.getApplicationContext());
                webView.setVisibility(View.VISIBLE);
                DcmAnalyticsApplication2 application = (DcmAnalyticsApplication2)activity.getApplication();
                DcmTracker2 tracker = application.getTracker();
                String url = this.authUrl;
                url = url + "?idsite=" + application.getSiteId();
                url = url + "&dcmanUid=" + tracker.getUserId(activity.getApplicationContext());
                url = url + "&referer=" + application.getApplicationUrl();
                this.webViewSetting(activity.getApplicationContext(), webView);
                CookieManager cookieManager = new CookieManager();
                cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
                CookieHandler.setDefault(cookieManager);
                activity.addContentView(webView, new RelativeLayout.LayoutParams(0, 0));
                webView.loadUrl(url);
                this.setBeforeAuthTime(activity.getApplicationContext());
            }
        } catch (Throwable var7) {
            DcmLog2.e(LOGGER_TAG, "webAuth error");
        }

    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void webViewSetting(Context context, WebView webView) {
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
    }

    public DcmTracker2 setUserId(String userId) {
        if (userId != null && userId.length() > 0) {
            this.userId = userId;
        }

        return this;
    }

    public DcmTracker2 setUserId(long userId) {
        return this.setUserId(Long.toString(userId));
    }

    protected String getUserId() {
        return this.userId;
    }

    public String getUserId(Context context) {
        try {
            SharedPreferences sp = context.getSharedPreferences("dcmanalytics", 0);
            this.userId = sp.getString("dcmanalyticsuuid", (String)null);
            if (TextUtils.isEmpty(this.userId)) {
                this.userId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("dcmanalyticsuuid", this.userId);
                editor.commit();
            }
        } catch (Exception var4) {
            DcmLog2.e(LOGGER_TAG, "getUserId error");
        }

        return this.userId;
    }

    private Long getBeforeAuthTime(Context context) {
        Long beforeAuthTime = -1L;

        try {
            SharedPreferences sp = context.getSharedPreferences("dcmanalytics", 0);
            beforeAuthTime = sp.getLong("dcmanalyticsauthtime", 0L);
        } catch (Exception var4) {
            DcmLog2.e(LOGGER_TAG, "getBeforeAuthTime error");
        }

        return beforeAuthTime;
    }

    private void setBeforeAuthTime(Context context) {
        try {
            SharedPreferences sp = context.getSharedPreferences("dcmanalytics", 0);
            Calendar calendar = Calendar.getInstance();
            Long time = calendar.getTimeInMillis();
            SharedPreferences.Editor editor = sp.edit();
            editor.putLong("dcmanalyticsauthtime", time);
            editor.commit();
        } catch (Exception var6) {
            DcmLog2.e(LOGGER_TAG, "setBeforeAuthTime error");
        }

    }

    private boolean checkAuth(Context context) {
        Long beforeAuthTime = this.getBeforeAuthTime(context);
        if (beforeAuthTime < 0L) {
            return false;
        } else {
            Long nowTime = Calendar.getInstance().getTimeInMillis();
            return nowTime - beforeAuthTime >= this.authInterval;
        }
    }

    public void setAuthInterval(Long time) {
        this.authInterval = time;
    }

    private final void setAuthUrl(String url) throws MalformedURLException {
        if (url == null) {
            throw new MalformedURLException("You must provide the dcmAnalytics URL!");
        } else {
            String path = url;
            if (!url.endsWith("/")) {
                path = url + "/";
            }

            this.authUrl = path;
        }
    }
}

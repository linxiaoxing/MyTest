package com.example.hmplayer.util;

import android.util.Log;

public class URLProviderUtils {

    /**
     * 获取首页的url
     *
     * @param offset 数据偏移量
     * @param size   返回数据的条目个数
     * @return url
     */
    public static String getHomeUrl(int offset, int size) {
        String url = "http://mapi.yinyuetai.com/suggestions/front_page.json?deviceinfo="
                + "{\"aid\":\"10201036\",\"os\":\"Android\","
                + "\"ov\":" + "\"" + getSystemVersion() + "\"" + ","
                + "\"rn\":\"480*800\","
                + "\"dn\":" + "\"" + getPhoneModel() + "\"" + ","
                + "\"cr\":\"46000\","
                + "\"as\":"
                + "\"WIFI\","
                + "\"uid\":"
                + "\"dbcaa6c4482bc05ecb0bf39dabf207d2\","
                + "\"clid\":110025000}"
                + "&offset=" + offset
                + "&size=" + size
                + "&v=4&rn=640*540";
        Log.i("Main_url", url);
        return url;
    }

    private static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    private static String getPhoneModel() {
        return android.os.Build.MODEL;
    }
}

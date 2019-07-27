package com.example.mydoc;

import android.content.Context;
import com.example.mydoc.helper.CryptHelper;
import org.dcm.analytics.sdk.DcmAnalyticsApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyDocApplication extends DcmAnalyticsApplication {

    // リリース前にフラグがfalse になっていることを確認
    public static final boolean MAINTENANCE_DCM = BuildConfig.MAINTENANCE;
    public static final boolean SHORT_UPDATE_INTERVAL = BuildConfig.SHORT_UPDATE_INTERVAL;
    public static final boolean KEY_SERVER_DEBUG = false;
    public static final boolean IS_DEBUG_AUTHENTICATION = BuildConfig.MAINTENANCE;
    public static final boolean IS_AUTOUPDATE_MESSAGE = false;
    public static final boolean IS_GA_DEBUG = BuildConfig.GA_DEBUG;
    public static final boolean IS_GA_DEBUG_APPVENDER = false;
    public static final boolean IS_CAMPAIGN_DEBUG = BuildConfig.GA_DEBUG;

    /**
     * Flavor名定義.
     */
    public final static String FLAVOR_PRODUCT               = "product";
    public final static String FLAVOR_MAINTENANCE           = "maintenance";
    public final static String FLAVOR_SHORT_UPDATE_INTERVAL = "short_update_interval";
    public final static int    FLAVOR_USAGE_CHECKVERSIONCODE= 20000;


    private long lastPauseTime;
    private static final int TIMEOUT = 5000;

    private byte[] key = null;
    private boolean nowUpdate = false;
    private boolean nowAdding = false;

    private boolean tracked = false;

    private CryptHelper cryptHelper;
    private KeyServerHelper keyServerHelper;
    private static final String FILE_CRYPT_KEY = "index";

    /**
     * アプリ内鍵を保存する.
     * @param key 暗号鍵
     */
    public final void setKey(final byte[] key) {
        try {
            FileOutputStream fos = this.openFileOutput(FILE_CRYPT_KEY, Context.MODE_PRIVATE);

            fos.write(key);
            fos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        this.key = key;
    }


    /**
     * アプリ内鍵を取得する.
     * @return 暗号鍵
     */
    public final byte[] getKey() {
        if (key != null) {
            return key;
        }
        try {
            FileInputStream fis = this.openFileInput(FILE_CRYPT_KEY);
            FileChannel fc = fis.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
            fc.read(buffer);
            buffer.clear();

            key = new byte[buffer.capacity()];
            buffer.get(key);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return key;
    }

}

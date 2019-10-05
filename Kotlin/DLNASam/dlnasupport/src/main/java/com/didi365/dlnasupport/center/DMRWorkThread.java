package com.didi365.dlnasupport.center;

import android.content.Context;

import com.didi365.dlna.jni.PlatinumJniProxy;
import com.didi365.dlnasupport.RenderApplication;
import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.CommonUtil;
import com.didi365.dlnasupport.util.LogFactory;

public class DMRWorkThread extends Thread implements IBaseEngine {

    private static final CommonLog log = LogFactory.createLog();

    private static final int CHECK_INTERVAL = 30 * 1000;

    private Context mContext = null;
    private boolean mStartSuccess = false;
    private boolean mExitFlag = false;

    private String mFriendName = "";
    private String mUUID = "";
    private RenderApplication mApplication;

    public DMRWorkThread(Context context) {
        mContext = context;

        mApplication = RenderApplication.getRenderApplication();
    }

    public void setFlag(boolean flag) {
        mStartSuccess = flag;
    }

    public void setParam(String friendName, String uuid) {
        mFriendName = friendName;
        mUUID = uuid;
        mApplication.updateDevInfo(mFriendName, mUUID);
    }

    public void awakeThread() {
        synchronized (this) {
            notifyAll();
        }
    }

    public void exit() {
        mExitFlag = true;
        awakeThread();
    }

    @Override
    public void run() {
        log.v("DMRWorkThread run...");
        while (true) {
            if (mExitFlag) {
                stopEngine();
                break;
            }
            refreshNotify();
            synchronized (this) {
                try {
                    wait(CHECK_INTERVAL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (mExitFlag) {
                stopEngine();
                break;
            }
        }
        log.v("DMRWorkThread over...");
    }

    public void refreshNotify() {
        log.v("refreshNotify");
        if (!CommonUtil.checkNetworkState(mContext)) {
            return;
        }
        if (!mStartSuccess) {
            stopEngine();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean ret = startEngine();
            if (ret) {
                mStartSuccess = true;
            }
        }
    }

    @Override
    public boolean startEngine() {
        if (mFriendName.length() == 0) {
            return false;
        }
        int ret = PlatinumJniProxy.startMediaRender(mFriendName, mUUID);
        log.v("startEngine ret " + ret);
        boolean result = (ret == 0 ? true : false);
        mApplication.setDevStatus(result);
        return result;
    }

    @Override
    public boolean stopEngine() {
        PlatinumJniProxy.stopDlnaMediaRender();
        mApplication.setDevStatus(false);
        return true;
    }

    @Override
    public boolean restartEngine() {
        setFlag(false);
        awakeThread();
        return true;
    }
}

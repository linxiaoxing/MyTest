package com.example.dlnasam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.didi365.dlnasupport.DeviceInfo;
import com.didi365.dlnasupport.DeviceUpdateBrocastFactory;
import com.didi365.dlnasupport.RenderApplication;
import com.didi365.dlnasupport.center.DlnaMediaModel;
import com.didi365.dlnasupport.center.DlnaMediaModelFactory;
import com.didi365.dlnasupport.center.MediaRenderProxy;
import com.didi365.dlnasupport.center.PlayerEventListener;
import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.DlnaUtils;
import com.didi365.dlnasupport.util.LogFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DeviceUpdateBrocastFactory.IDevUpdateListener, PlayerEventListener{

    private static final CommonLog log = LogFactory.createLog(MainActivity.class.getSimpleName());

    private Button mBtnStart;
    private Button mBtnReset;
    private Button mBtnStop;

    private Button mBtnEditName;
    private TextView mETName;
    private TextView mTVDevInfo;

    private MediaRenderProxy mRenderProxy;
    private RenderApplication mApplication;
    private DeviceUpdateBrocastFactory mBrocastFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity","onCreate");
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setupView();
        initData();

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        Log.v("MainActivity","screenWidth " + screenWidth);
        Log.v("MainActivity","screenHeight " + screenHeight);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unInitData();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DlnaMediaModel mediaInfo = (DlnaMediaModel) msg.obj;
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SimplePlayActivity.class);
            DlnaMediaModelFactory.pushMediaModelToIntent(intent, mediaInfo);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    };

    private void setupView() {
        mBtnStart = (Button) findViewById(R.id.btn_init);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnStop = (Button) findViewById(R.id.btn_exit);
        mBtnEditName = (Button) findViewById(R.id.bt_dev_name);
        mBtnStart.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mBtnEditName.setOnClickListener(this);

        mTVDevInfo = (TextView) findViewById(R.id.tv_dev_info);
        mETName = (TextView) findViewById(R.id.et_dev_name);
    }

    private void initData() {
        mApplication = RenderApplication.getRenderApplication();
        mRenderProxy = MediaRenderProxy.getInstance();
        mBrocastFactory = new DeviceUpdateBrocastFactory(this);

        RenderApplication.getRenderApplication().setPlayerEventListener(this);

        String dev_name = DlnaUtils.getDevName(this);
        mETName.setText(dev_name);

        updateDevInfo(mApplication.getDevInfo());
        mBrocastFactory.register(this);
    }

    private void unInitData() {
        mBrocastFactory.unregister();
    }

    private void updateDevInfo(DeviceInfo object) {
        if (object != null) {
            String status = object.status ? "open" : "close";
            String text = "status: " + status + "\n" +
                    "friend name: " + object.dev_name + "\n" +
                    "uuid: " + object.uuid;
            mTVDevInfo.setText(text);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_init:
                log.v("click start");
                start();
                break;
            case R.id.btn_reset:
                log.v("click reset");
                reset();
                break;
            case R.id.btn_exit:
                log.v("click exit");
                stop();
                finish();
                break;
            case R.id.bt_dev_name:
                log.v("click devname");
                change();
                break;
        }
    }

    private void start() {
        mRenderProxy.startEngine();
    }

    private void reset() {
        mRenderProxy.restartEngine();
    }

    private void stop() {
        mRenderProxy.stopEngine();
    }

    private void change() {
        if (mETName.isEnabled()) {
            DlnaUtils.setDevName(this, mETName.getText().toString());
        }
    }

    @Override
    public void onUpdate() {
        log.v("onUpdate");
        updateDevInfo(mApplication.getDevInfo());
    }

    @Override
    public void startPlayVideo(DlnaMediaModel mediaInfo) {

    }

}

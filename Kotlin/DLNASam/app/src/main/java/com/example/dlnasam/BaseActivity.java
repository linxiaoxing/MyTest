package com.example.dlnasam;

import android.app.Activity;
import android.os.Bundle;

import com.didi365.dlnasupport.RenderApplication;

public class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RenderApplication.onCatchError(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

        RenderApplication.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RenderApplication.onResume(this);
    }
}
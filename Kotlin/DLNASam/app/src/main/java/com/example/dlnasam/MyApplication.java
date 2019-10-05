package com.example.dlnasam;

import android.app.Application;

import com.didi365.dlnasupport.RenderApplication;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RenderApplication.init(this);
    }
}
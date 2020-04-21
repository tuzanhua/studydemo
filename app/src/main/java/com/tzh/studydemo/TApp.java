package com.tzh.studydemo;

import android.app.Application;

import com.tzh.leakcanary.TLeakCanary;


/**
 * create by tuzanhua on 2020/4/18
 */
public class TApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TLeakCanary.getInstance().install(this);
    }
}

package com.tzh.studydemo;

import android.app.Application;
import android.util.Log;

import com.tzh.leakcanary.TLeakCanary;


/**
 * create by tuzanhua on 2020/4/18
 */
public class TApp extends Application {
    private static final String TAG = "Tzh";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"TAPP  application " + this.toString());
        TLeakCanary.getInstance().install(this);
    }
}

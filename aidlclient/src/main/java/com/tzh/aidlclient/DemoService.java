package com.tzh.aidlclient;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * create by tuzanhua on 2020/5/8
 */
public class DemoService extends Service {
    private static final String TAG = "DemoService";
    public DemoService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate :");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand intent :" +intent.getAction());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind :" +intent.getAction());
        return null;
    }
}

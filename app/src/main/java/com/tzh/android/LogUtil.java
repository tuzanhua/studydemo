package com.tzh.android;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * create by tuzanhua on 2020/4/16
 */
public class LogUtil {

    private static final String TAG = "study";

    Handler handler = new Handler();
    public static void e(String msg) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                    }
                };
                Looper.loop();

                handler.sendEmptyMessage(0);
            }
        }).start();

    }
}

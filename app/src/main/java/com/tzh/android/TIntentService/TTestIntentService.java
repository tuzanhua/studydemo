package com.tzh.android.TIntentService;

import android.content.Intent;
import android.util.Log;

/**
 * create by tuzanhua on 2020/4/10
 */
public class TTestIntentService extends TIntentService {
    private static final String TAG = "TTestIntentService";

    @Override
    public void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
            Log.e(TAG, "耗时操作执行完成了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

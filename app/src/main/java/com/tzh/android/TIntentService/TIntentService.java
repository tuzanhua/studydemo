package com.tzh.android.TIntentService;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.Nullable;

import com.tzh.android.THandlerThread.THandlerThread;

/**
 * create by tuzanhua on 2020/4/10
 * <p>
 * 学习安卓源码的封装
 * {@link android.app.IntentService}
 * <p>
 * 这个类的存在就是为了简化在 service 里面做简单的耗时操作 耗时操作完成 stop self
 */
public abstract class TIntentService extends Service {

    private boolean mRedelivery;
    private ServiceHandler serviceHandler;

    public TIntentService() {

    }

    @Override
    public void onCreate() {
        // 因为多次start 会多次调用startcommand 但是onCreate 只会执行一次
        THandlerThread tHandlerThread = new THandlerThread("intent_service");
        tHandlerThread.start();
        serviceHandler = new ServiceHandler(tHandlerThread.getMyLooper());
    }

    public class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            onHandleIntent((Intent) msg.obj);
            int arg1 = msg.arg1;
            stopSelf(arg1);
        }
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Message message = serviceHandler.obtainMessage();
        message.obj = intent;
        message.arg1 = startId;
        serviceHandler.sendMessage(message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        onStart(intent, startId);
        return mRedelivery ? START_REDELIVER_INTENT : START_NOT_STICKY;  // 四种返回值 看下
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;


    }


    public abstract void onHandleIntent(Intent intent);
}

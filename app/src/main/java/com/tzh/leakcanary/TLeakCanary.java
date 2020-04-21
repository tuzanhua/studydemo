package com.tzh.leakcanary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import com.tzh.android.LogUtil;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * create by tuzanhua on 2020/4/18
 * <p>
 * 思路 : 首先什么时候会产生内存泄漏(当前页面调用了ondestory 之后)
 * -> 用什么手段可以进行泄漏检测  WeakReference + ReferenceQueue
 * -> 在什么时机 将需要检测泄漏的 activity 与 WeakReferenceQueue 关联起来呢
 * -> 减小侵入性  不在基类 注入 ? 那么在哪里呢  Lifecycle
 */
public class TLeakCanary {
    private static TLeakCanary instance = new TLeakCanary();

    public static TLeakCanary getInstance() {
        return instance;
    }

    ReferenceQueue<Activity> referenceQueue = new ReferenceQueue<>();

    public void install(Context context) {

        ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                // 在执行onDestroyed() 之后 查看引用队列是不是有他 如果有就没有泄漏 如果没有说明泄漏了
                LogUtil.e("onActivityDestroyed :" + activity.getClass().getSimpleName());
                WeakReference<Activity> activityWeakReference = new WeakReference<Activity>(activity, referenceQueue);
                System.gc();
                HandlerThread handlerThread = new HandlerThread("executor");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new AssertionError();
                }
                System.gc();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(referenceQueue.poll() == null){
                            LogUtil.e(activity.getClass().getSimpleName() + "发生内存泄漏了");
                            return;
                        }
                        while (referenceQueue.poll() != null) {
                            if (referenceQueue.poll().get() == activity) {
                                LogUtil.e(activity.getClass().getSimpleName() + "发生内存泄漏了");
                            }
                        }
                    }
                }, 5000);

            }
        });


    }
}

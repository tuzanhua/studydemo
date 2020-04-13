package com.tzh.android.THandlerThread;

import android.os.Looper;
import android.os.Process;

/**
 * create by tuzanhua on 2020/4/9
 * <p>
 * {@link android.os.HandlerThread}
 * <p>
 * Handy class for starting a new thread that has a looper. The looper can then be
 * used to create handler classes. Note that start() must still be called.
 * 线程在同一时间只能处理一件事
 * 此类作用 : 利用 {@link android.os.MessageQueue} 消息队列 {@link android.os.Looper} 完成一个任务在执行下一个任务
 * 适用单线程执行任务
 */
public class THandlerThread extends Thread {

    int mPriority;
    private Looper myLooper;

    public THandlerThread(String name) {
        super(name);
    }

    public THandlerThread(String name, int priority) {
        super(name);
        mPriority = priority;
    }

    @Override
    public void run() {
        int mPid = Process.myPid();
        Looper.prepare();
        synchronized (this) {
            myLooper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(mPriority);
        Looper.loop();
    }

    public Looper getMyLooper() {
        if (!isAlive()) {
            return null;
        }
        // 防止线程开起来 looper 还没有创建成功造成的bug
        synchronized (this) {
            while (isAlive() && myLooper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return myLooper;
    }

    public boolean quit() {
        if (getMyLooper() != null) {
            getMyLooper().quit();
            return true;
        }
        return false;
    }
}

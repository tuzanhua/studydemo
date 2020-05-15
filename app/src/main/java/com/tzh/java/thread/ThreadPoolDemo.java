package com.tzh.java.thread;

import android.widget.EditText;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * create by tuzanhua on 2020/5/13
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {


        ThreadPoolManager.getInstance().executed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("run 执行结束了");
            }
        });

        System.out.println("main 执行结束了");

    }
}

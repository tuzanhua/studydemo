package com.tzh.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * create by tuzanhua on 2020/5/13
 */
public class ThreadPoolManager {

    private final ThreadPoolExecutor executor;

    private ThreadPoolManager(){
        executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                throw new RejectedExecutionException("");
            }
        });
    }


    public static ThreadPoolManager getInstance(){
        return new ThreadPoolManager();
    }

    public void executed(Runnable runnable){
        executor.execute(runnable);
    }
}

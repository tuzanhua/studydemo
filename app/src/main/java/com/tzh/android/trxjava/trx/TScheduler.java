package com.tzh.android.trxjava.trx;

import java.util.concurrent.Executor;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TScheduler {

   private Executor executor;

    public TScheduler(Executor executor) {
        this.executor = executor;
    }

    public Worker createWorker() {
        return new Worker(executor);
    }


    public static class Worker {
        Executor executor;

        public Worker(Executor executor) {
            this.executor = executor;
        }

        public void schedule(Runnable runnable) {
            executor.execute(runnable);
        }
    }
}

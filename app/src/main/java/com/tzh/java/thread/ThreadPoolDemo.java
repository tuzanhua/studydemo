package com.tzh.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * create by tuzanhua on 2020/5/13
 */
public class ThreadPoolDemo {

    private static BlockingQueue<String> queue;

    public static void main(String[] args) {

        TzhThreadPool tzhThreadPool = new TzhThreadPool(3, 5, new LinkedBlockingQueue<>(90), 30, TimeUnit.SECONDS);

        for (int i = 0; i < 100; i++) {
            tzhThreadPool.execute(new MyTask(i));
        }

    }

    static class MyTask implements Runnable {

        private int i;

        public MyTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行了第 " + i  +" 个任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

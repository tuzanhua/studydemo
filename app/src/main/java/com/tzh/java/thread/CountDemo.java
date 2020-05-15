package com.tzh.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * create by tuzanhua on 2020/5/13
 */
public class CountDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start");
                    Thread.sleep(2000);
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("执行了吗");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("start11");

                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("执行了吗");
            }
        }).start();

    }
}

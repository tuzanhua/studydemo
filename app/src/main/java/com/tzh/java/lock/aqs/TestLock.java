package com.tzh.java.lock.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * create by tuzanhua on 2020/5/15
 */
public class TestLock {

    private static MyLock myLock;

    public static void main(String[] args) throws InterruptedException {

//        Thread[] threads = new Thread[100];
//        MyTask myTask = new MyTask();
//        myLock = new MyLock();
//        for (int i = 0; i < 100; i++) {
//            Thread thread = new Thread(myTask);
//            threads[i] = thread;
//        }
//
//        for (Thread thread : threads) {
//            thread.start();
//        }
//
//        for (Thread thread : threads) {
//            thread.join();
//        }
//        System.out.println("m =:" + m);


        new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park(this);
                boolean s = Thread.currentThread().interrupted();
                System.out.println("执行结束了吗 :  " + s);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行结束了吗");
            }
        }).start();

    }

    static int m = 0;


    public static class MyTask implements Runnable {
        @Override
        public void run() {
            myLock.lock();
            for (int j = 0; j < 100; j++) {
                m++;
            }
            myLock.unlock();
        }
    }
}

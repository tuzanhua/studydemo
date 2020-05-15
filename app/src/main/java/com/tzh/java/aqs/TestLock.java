package com.tzh.java.aqs;

/**
 * create by tuzanhua on 2020/5/15
 */
public class TestLock {

    private static MyLock myLock;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];
        MyTask myTask = new MyTask();
        myLock = new MyLock();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(myTask);
            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("m =:" + m);

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

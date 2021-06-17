package com.tzh.java.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by tuzanhua on 2020/4/15
 * <p>
 * 用两个线程交替打印 A B
 * t1 只打印A t2 只打印B
 */
public class AlternateDemo {

    public static void main(String[] args) {


        // func1 ===============================
//        AtomicInteger atomicInteger = new AtomicInteger();
//        T1 t1 = new T1(atomicInteger);
//        T2 t2 = new T2(atomicInteger);
//        Thread thread = new Thread(t1);
//        Thread thread1 = new Thread(t2);
//        thread.start();
//        thread1.start();
        //============================================


        String str1 = "ABCDEFG";
        String str2 = "1234567";

        char[] chars = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // func2  ReentrantLock condition
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition t1Condition = reentrantLock.newCondition();
        Condition t2Condition = reentrantLock.newCondition();

//        new Thread(() -> {
//            try {
//                reentrantLock.lock();
//                for (int i = 0; i < chars.length; i++) {
//                    System.out.println(chars[i]);
//                    t2Condition.signal();
//                    try {
//                        t1Condition.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                t2Condition.signal();
//            } finally {
//                reentrantLock.unlock();
//
//            }
//
//        }).start();
//
//
//        new Thread(() -> {
//            try {
//                reentrantLock.lock();
//
//                for (int i = 0; i < chars2.length; i++) {
//                    System.out.println(chars2[i]);
//                    t1Condition.signal();
//                    try {
//                        t2Condition.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                t1Condition.signal();
//            } finally {
//                reentrantLock.unlock();
//
//            }
//
//        }).start();

        //==============================================


        // func3 ========================================

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < chars.length; i++) {
                    System.out.println(chars[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < chars2.length; i++) {

                    System.out.println(chars2[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.notify();
            }

        }).start();

    }

    static class T1 implements Runnable {

        AtomicInteger atomicInteger;

        public T1(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 100) {
                if (atomicInteger.get() % 2 == 0) {
                    System.out.println(Thread.currentThread() + "print :" + "A" + "   " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    static class T2 implements Runnable {

        AtomicInteger atomicInteger;

        public T2(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 100) {
                if (atomicInteger.get() % 2 != 0) {
                    System.out.println(Thread.currentThread() + "print :" + "B" + "   " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }
}

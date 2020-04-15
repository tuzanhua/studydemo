package com.tzh.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * create by tuzanhua on 2020/4/15
 * <p>
 * 用两个线程交替打印 A B
 * t1 只打印A t2 只打印B
 */
public class AlternateDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        T1 t1 = new T1(atomicInteger);
        T2 t2 = new T2(atomicInteger);
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();
        thread1.start();

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

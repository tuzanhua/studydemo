package com.tzh.java.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by tuzanhua on 2020/4/15
 * A B C 三个线程交替打印 个打印10次
 */
public class ABCAlternatePrintDemo {

    public static void main(String[] args) {

        // fun one
//        AtomicInteger atomicInteger = new AtomicInteger();
//        new Thread1(atomicInteger).start();
//        new Thread2(atomicInteger).start();
//        new Thread3(atomicInteger).start();

        //fun two

        new ThreadFun2_1().start();
        new ThreadFun2_2().start();
        new ThreadFun2_3().start();

    }


    //=========================================================================================== fun one start
    static class Thread1 extends Thread {
        private AtomicInteger atomicInteger;

        public Thread1(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 30) {
                if (atomicInteger.get() % 3 == 0) {
                    System.out.println("A" + "  " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    static class Thread2 extends Thread {
        private AtomicInteger atomicInteger;

        public Thread2(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 30) {
                if (atomicInteger.get() % 3 == 1) {
                    System.out.println("B" + "  " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    static class Thread3 extends Thread {
        private AtomicInteger atomicInteger;

        public Thread3(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 30) {
                if (atomicInteger.get() % 3 == 2) {
                    System.out.println("C" + "  " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    //============================================================================================ fun one end


    //==============================================================================================fun two start
    static volatile int count = 0;
    static ReentrantLock lock = new ReentrantLock();

    static class ThreadFun2_1 extends Thread {
        public ThreadFun2_1() {
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count < 30) {
                        if (count % 3 == 0) {
                            System.out.println("A" + "    " + count);
                            ++count;
                        }
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadFun2_2 extends Thread {
        public ThreadFun2_2() {
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count < 30) {
                        if (count % 3 == 1) {
                            System.out.println("B" + "    " + count);
                            ++count;
                        }
                    } else {
                        break;
                    }

                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadFun2_3 extends Thread {
        public ThreadFun2_3() {
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count < 30) {
                        if (count % 3 == 2) {
                            System.out.println("c" + "    " + count);
                            ++count;
                        }
                    } else {
                        break;
                    }

                } finally {
                    lock.unlock();
                }

            }
        }
    }
    //===========================================================================================================fun two end

    //=========================================================================================================== fun three start

    //这里如果用 synchronized wait notify  那么每个线程应该持有几个锁呢 ? A -> B -> C -> A
}



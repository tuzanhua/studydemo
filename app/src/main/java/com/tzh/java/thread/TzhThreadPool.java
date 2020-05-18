package com.tzh.java.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by tuzanhua on 2020/5/15
 */
public class TzhThreadPool {

    /**
     * 核心线线程池数量
     */
    private int coreSize;

    /**
     * 最大线程数量
     */
    private int maxSize;

    /**
     * 这个是线程池的核心 阻塞队列 基于ReentrantLock (AQS)
     */
    private BlockingQueue<Runnable> blockingQueue;

    /**
     * 非核心线程的超时时间
     */
    private long timeOut = 0;


    private TimeUnit timeUnit;


    /**
     * 防止用户在子线程创建线程
     */
    private Lock mainLock = new ReentrantLock();

    private AtomicInteger threadCount = new AtomicInteger(0);

    public TzhThreadPool(int coreSize, int maxSize, BlockingQueue<Runnable> blockingQueue, long timeOut, TimeUnit timeUnit) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.blockingQueue = blockingQueue;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
    }

    public void execute(Runnable runnable) {
        mainLock.lock();
        try {
            if (threadCount.get() < coreSize) {
                //创建线程
                new Worker(true, runnable).start();
            } else {
                //addWorkerQueue
                if (!blockingQueue.offer(runnable)) {
                    if (threadCount.get() < (coreSize + maxSize)) {
                        new Worker(false, runnable).start();
                    } else {
                        // TODO 拒绝策略
                    }
                }
            }
        } finally {
            mainLock.unlock();
        }
    }


    private Runnable getTarget(boolean core) {
        for (; ; ) {
            if (core) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (blockingQueue.isEmpty()) {
                    if (timeOut != 0 && timeUnit != null) {
                        try {
                            return blockingQueue.poll(timeOut, timeUnit);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        return blockingQueue.poll();
                    }
                } else {
                    return blockingQueue.poll();
                }

            }
        }
    }


    /**
     * 真正工作的类
     */
    private class Worker implements Runnable {

        private boolean core = false;

        private Thread thread = new Thread(this);

        private Runnable target;

        public Worker(boolean core, Runnable target) {
            this.core = core;
            this.target = target;
            if (core) {
                thread.setName(threadCount.incrementAndGet() + "号  core thread");
            } else {
                thread.setName(threadCount.incrementAndGet() + "号  non-core thread");
            }
        }

        @Override
        public void run() {
            while (target != null || (target = getTarget(core)) != null) {
                target.run();
                target = null;
            }
        }

        public Thread getThread() {
            return thread;
        }

        public void start() {
            thread.start();
        }
    }

    public interface  RejectHandler{
        void reject(TzhThreadPool pool,Runnable runnable);
    }

}

package com.tzh.java.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * create by tuzanhua on 2020/5/15
 */
public class MyLock implements Lock {

    Sync sync;

    public MyLock() {
        sync = new Sync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            Thread currentThread = Thread.currentThread();
            if (compareAndSetState(0, arg) && currentThread != getExclusiveOwnerThread()) { // 如果 赋值成功了
                setExclusiveOwnerThread(currentThread);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState();
            int c = state - arg;
            boolean re = c == 0;
            if (re) {
                setState(0);
                setExclusiveOwnerThread(null);
            } else {
                setState(c);
            }
            return re;
        }

        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }
    }
}

package com.tzh.java.thread;

import java.util.concurrent.Callable;

/**
 * create by tuzanhua on 2020/4/14
 *
 * 创建线程的方式 {@link Callable}和{@link java.util.concurrent.FutureTask} 创建带返回值的线程
 */
public class ThreadDemo1 {
    public static void main(String[] args) {

    }


    class CallableImpl implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "返回数据";
        }
    }

}

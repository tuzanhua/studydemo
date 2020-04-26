package com.tzh.java.dynamicproxy;

/**
 * create by tuzanhua on 2020/4/26
 */
public class RealCall<T> implements Call<T> {

    @Override
    public void enque(Callback<T> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行请求了");
                try {
                    Thread.sleep(2000);
                    callback.success((T) "返回数据了呢");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

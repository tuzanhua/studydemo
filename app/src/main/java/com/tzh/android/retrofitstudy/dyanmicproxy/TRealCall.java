package com.tzh.android.retrofitstudy.dyanmicproxy;

public class TRealCall implements TCall {

    @Override
    public void enqueue(TCallback ttCallback) {
        //模拟请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    ttCallback.success(parseResponse());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private Object parseResponse() {
        return "好了请求成功了,成功的拿到数据了";
    }
}

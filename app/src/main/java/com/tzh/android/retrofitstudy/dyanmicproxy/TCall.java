package com.tzh.android.retrofitstudy.dyanmicproxy;

import com.tzh.java.dynamicproxy.Callback;

public interface TCall<T> {

    void enqueue(TCallback<T> ttCallback);
}

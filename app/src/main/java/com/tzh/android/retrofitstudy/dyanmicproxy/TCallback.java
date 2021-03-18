package com.tzh.android.retrofitstudy.dyanmicproxy;

public interface TCallback<T> {
    void success(T t);
    void fail(String msg);
}

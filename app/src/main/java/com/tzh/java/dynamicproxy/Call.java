package com.tzh.java.dynamicproxy;

/**
 * create by tuzanhua on 2020/4/26
 */
public interface Call<T> {
    void enque(Callback<T> callback);
}

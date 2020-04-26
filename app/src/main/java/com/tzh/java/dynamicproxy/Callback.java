package com.tzh.java.dynamicproxy;

/**
 * create by tuzanhua on 2020/4/26
 */
public interface Callback<T> {
    void success(T data);
}

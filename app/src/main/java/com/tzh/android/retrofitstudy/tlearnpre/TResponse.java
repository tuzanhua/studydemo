package com.tzh.android.retrofitstudy.tlearnpre;

/**
 * create by tuzanhua on 2020/4/24
 */
public class TResponse<T> {
    int errno;
    String errmsg;
    T data;


    @Override
    public String toString() {
        return "TResponse{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}

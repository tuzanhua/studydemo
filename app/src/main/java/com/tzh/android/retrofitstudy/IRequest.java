package com.tzh.android.retrofitstudy;

import com.tzh.android.retrofitstudy.tlearnpre.TResponse;
import com.tzh.java.thread.ThreadDemo1;

import retrofit2.Call;

/**
 * create by tuzanhua on 2020/4/17
 */
public interface IRequest {

    Call<TResponse<String>> getName();
}

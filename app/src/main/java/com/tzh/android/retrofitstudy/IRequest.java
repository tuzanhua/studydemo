package com.tzh.android.retrofitstudy;

import retrofit2.Call;

/**
 * create by tuzanhua on 2020/4/17
 */
public interface IRequest {
    Call<String> getData();
}

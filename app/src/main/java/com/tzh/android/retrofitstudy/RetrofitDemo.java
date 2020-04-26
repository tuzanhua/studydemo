package com.tzh.android.retrofitstudy;

import com.tzh.android.retrofitstudy.tlearnpre.TResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * create by tuzanhua on 2020/4/16
 */
public class RetrofitDemo {

    public void test(){

        OkHttpClient.Builder builder1 = new OkHttpClient().newBuilder();
        OkHttpClient client = builder1.build();


        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("");
        Retrofit retrofit = builder.build();
        IRequest iRequest = retrofit.create(IRequest.class);
        Call<TResponse<String>> name = iRequest.getName();
        name.enqueue(new Callback<TResponse<String>>() {
            @Override
            public void onResponse(Call<TResponse<String>> call, Response<TResponse<String>> response) {
                TResponse<String> body = response.body();
            }

            @Override
            public void onFailure(Call<TResponse<String>> call, Throwable t) {

            }
        });
    }
}

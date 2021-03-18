package com.tzh.android.retrofitstudy.dyanmicproxy;

public class TRetrofitCoreTest {
    public static void main(String[] args) {
        TRetrofit tRetrofit = new TRetrofit();
        TIRequestServer tiRequestServer = tRetrofit.create(TIRequestServer.class);
        TCall<THttpResponse<String>> netData = tiRequestServer.getNetData();
        netData.enqueue(new TCallback<THttpResponse<String>>() {
            @Override
            public void success(THttpResponse<String> stringTHttpResponse) {

            }

            @Override
            public void fail(String msg) {

            }
        });
    }
}

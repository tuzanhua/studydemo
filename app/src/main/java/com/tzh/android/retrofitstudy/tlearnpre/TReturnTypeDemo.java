package com.tzh.android.retrofitstudy.tlearnpre;

import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tzh.android.retrofitstudy.IRequest;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * create by tuzanhua on 2020/4/24
 */
public class TReturnTypeDemo {

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        Call<TResponse<Demo1>> params = getParams();
        String json = "{\n" +
                "    \"errno\":0,\n" +
                "    \"errmsg\":\"\",\n" +
                "    \"data\":{\n" +
                "        \"String\":\"1\",\n" +
                "        \"age\":0\n" +
                "    }\n" +
                "}";

        TReturnTypeDemo tReturnTypeDemo = new TReturnTypeDemo();
        try {
            Method getParams = tReturnTypeDemo.getClass().getDeclaredMethod("getParams");
            Class<?> returnType = getParams.getReturnType();
            Type genericReturnType = getParams.getGenericReturnType();

            System.out.println(genericReturnType);
            if (genericReturnType instanceof ParameterizedType) {

                Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();

                Type responseType = actualTypeArguments[0];
                System.out.println("responseType :          " + responseType);
                Gson gson = new Gson();
                TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(responseType));
                JsonReader jsonReader = gson.newJsonReader(new StringReader(json));
                try {
                    Object read = adapter.read(jsonReader);
                    System.out.println(read.toString());



                } catch (IOException e) {
                    e.printStackTrace();
                }
                TConverResponse<TResponse<Demo1>> converResponse = new TConverResponse<>();
                TResponse<Demo1> converter = converResponse.Converter(responseType, json);



                System.out.println("=====converter==========="  + converter.toString());
                System.out.println("==========================");
                Object convert = converResponse.convert();
                System.out.println("===========convert  ==============="  + convert.getClass().getSimpleName());
//                Object o = gson.fromJson(json, responseType);
//                System.out.println(o.toString());

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public static Call<TResponse<Demo1>> getParams() {
        // zhuashuanghsdhfa jdf
        return new TCall<TResponse<Demo1>>();
    }

    static class TCall<T> implements Call<T> {


        @Override
        public Response<T> execute() throws IOException {
            return null;
        }

        @Override
        public void enqueue(Callback<T> callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public void cancel() {

        }

        @Override
        public boolean isCanceled() {
            return false;
        }

        @Override
        public Call<T> clone() {
            return null;
        }

        @Override
        public Request request() {
            return null;
        }

        @Override
        public Timeout timeout() {
            return null;
        }
    }


    static class Demo1 {
        String name;
        int age;


        @Override
        public String toString() {
            return "Demo1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

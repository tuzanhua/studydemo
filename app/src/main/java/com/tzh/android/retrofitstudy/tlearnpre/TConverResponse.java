package com.tzh.android.retrofitstudy.tlearnpre;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TConverResponse<T> {

    public T Converter(Type responseType, String json) {
        Gson gson = new Gson();
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(responseType));
        JsonReader jsonReader = gson.newJsonReader(new StringReader(json));
        try {
            T read = (T) adapter.read(jsonReader);
            System.out.println(read.toString());
            return read;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <M> M convert(){
        return (M) new Object();
    }
}

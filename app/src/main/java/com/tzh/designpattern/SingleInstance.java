package com.tzh.designpattern;

import android.content.Context;

/**
 * create by tuzanhua on 2020/4/16
 */
public class SingleInstance {
    private static volatile SingleInstance intance;
    private Context context;

    private SingleInstance(Context context) {
        this.context = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (intance == null) {
            synchronized (SingleInstance.class) {
                if (intance == null) {
                    intance = new SingleInstance(context);
                }
            }
        }
        return intance;
    }

    public static void show(Context context){

    }
}

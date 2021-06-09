package com.xxx.designpattern.factory.factorymethod.product;

public class DatabaseLogger implements ILogger {
    @Override
    public void writeLogger(String tag, String msg) {
        System.out.println("DatabaseLogger :" + tag + msg);
    }
}

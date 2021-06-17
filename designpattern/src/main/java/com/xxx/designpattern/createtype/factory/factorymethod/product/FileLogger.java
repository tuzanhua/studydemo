package com.xxx.designpattern.createtype.factory.factorymethod.product;

public class FileLogger implements ILogger {
    @Override
    public void writeLogger(String tag, String msg) {
        System.out.println("FileLogger :" + tag + msg);
    }

}

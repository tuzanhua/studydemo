package com.xxx.designpattern.createtype.factory.factorymethod;

import com.xxx.designpattern.createtype.factory.factorymethod.factory.DatabaseLoggerFactory;
import com.xxx.designpattern.createtype.factory.factorymethod.factory.FileLoggerFactory;
import com.xxx.designpattern.createtype.factory.factorymethod.factory.ILoggerFactory;
import com.xxx.designpattern.createtype.factory.factorymethod.product.ILogger;

public class FactoryMethodClient {

    public static void main(String[] args) {
       ILoggerFactory factory = new  DatabaseLoggerFactory();
        ILogger logger = factory.createLogger();
        logger.writeLogger("tzh","开始写日志了哦");

        ILoggerFactory factory1 = new FileLoggerFactory();
        ILogger logger1 = factory1.createLogger();
        logger1.writeLogger("tzh","开始写日志了小伙子们");
    }
}

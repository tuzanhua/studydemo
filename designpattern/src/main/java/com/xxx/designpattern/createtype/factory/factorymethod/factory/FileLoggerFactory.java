package com.xxx.designpattern.createtype.factory.factorymethod.factory;

import com.xxx.designpattern.createtype.factory.factorymethod.product.FileLogger;
import com.xxx.designpattern.createtype.factory.factorymethod.product.ILogger;

public class FileLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new FileLogger();
    }
}

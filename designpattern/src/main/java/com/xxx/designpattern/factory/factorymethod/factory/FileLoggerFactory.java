package com.xxx.designpattern.factory.factorymethod.factory;

import com.xxx.designpattern.factory.factorymethod.product.FileLogger;
import com.xxx.designpattern.factory.factorymethod.product.ILogger;

public class FileLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new FileLogger();
    }
}

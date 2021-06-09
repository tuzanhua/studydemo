package com.xxx.designpattern.factory.factorymethod.factory;

import com.xxx.designpattern.factory.factorymethod.product.DatabaseLogger;
import com.xxx.designpattern.factory.factorymethod.product.FileLogger;
import com.xxx.designpattern.factory.factorymethod.product.ILogger;

public class DatabaseLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new DatabaseLogger();
    }
}

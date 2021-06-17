package com.xxx.designpattern.createtype.factory.factorymethod.factory;

import com.xxx.designpattern.createtype.factory.factorymethod.product.DatabaseLogger;
import com.xxx.designpattern.createtype.factory.factorymethod.product.ILogger;

public class DatabaseLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new DatabaseLogger();
    }
}

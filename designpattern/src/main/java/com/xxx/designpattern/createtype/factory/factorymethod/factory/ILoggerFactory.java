package com.xxx.designpattern.createtype.factory.factorymethod.factory;

import com.xxx.designpattern.createtype.factory.factorymethod.product.ILogger;

public interface ILoggerFactory {
    ILogger createLogger();
}

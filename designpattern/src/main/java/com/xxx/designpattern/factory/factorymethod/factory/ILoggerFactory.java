package com.xxx.designpattern.factory.factorymethod.factory;

import com.xxx.designpattern.factory.factorymethod.product.ILogger;

public interface ILoggerFactory {
    ILogger createLogger();
}

package com.xxx.designpattern.factory.abstractfactory.factory;

import com.xxx.designpattern.factory.abstractfactory.Request;
import com.xxx.designpattern.factory.abstractfactory.Response;
import com.xxx.designpattern.factory.abstractfactory.product.Convert;
import com.xxx.designpattern.factory.abstractfactory.product.RequestConvert1;
import com.xxx.designpattern.factory.abstractfactory.product.ResponseConvert1;

public class ConcreteConvertFactory1 extends ConvertFactory {

    public static ConcreteConvertFactory1 create() {
        return new ConcreteConvertFactory1();
    }

    @Override
    public Convert<String, Request> createRequestConvert() {
        return new RequestConvert1();
    }

    @Override
    public Convert<Response, String> createResponseConvert() {
        return new ResponseConvert1();
    }
}

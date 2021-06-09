package com.xxx.designpattern.factory.abstractfactory;

import com.xxx.designpattern.factory.abstractfactory.factory.ConcreteConvertFactory1;
import com.xxx.designpattern.factory.abstractfactory.product.Convert;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        ConcreteConvertFactory1 concreteConvertFactory1 = ConcreteConvertFactory1.create();
        Convert<String, Request> requestConvert = concreteConvertFactory1.createRequestConvert();
        Request name = requestConvert.convert("name");
        System.out.println(name.params);

        Convert<Response, String> responseConvert = concreteConvertFactory1.createResponseConvert();
        Response response = new Response();
        response.result = name.params + "返回值 +++";
        responseConvert.convert(response);

        System.out.println(response.result);

    }
}

package com.xxx.designpattern.createtype.factory.abstractfactory.product;

import com.xxx.designpattern.createtype.factory.abstractfactory.Request;

public class RequestConvert1 implements Convert<String, Request> {
    @Override
    public Request convert(String params) {
        Request request = new Request();
        request.params = params;
        return request;
    }
}

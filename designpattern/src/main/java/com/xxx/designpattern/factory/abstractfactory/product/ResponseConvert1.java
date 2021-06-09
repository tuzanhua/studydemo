package com.xxx.designpattern.factory.abstractfactory.product;

import com.xxx.designpattern.factory.abstractfactory.Response;

public class ResponseConvert1 implements Convert<Response, String> {
    @Override
    public String convert(Response s) {
        return s.result;
    }
}

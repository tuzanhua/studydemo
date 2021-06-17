package com.xxx.designpattern.createtype.factory.abstractfactory.product;

import com.xxx.designpattern.createtype.factory.abstractfactory.Response;

public class ResponseConvert1 implements Convert<Response, String> {
    @Override
    public String convert(Response s) {
        return s.result;
    }
}

package com.xxx.designpattern.createtype.factory.abstractfactory.factory;

import com.xxx.designpattern.createtype.factory.abstractfactory.Request;
import com.xxx.designpattern.createtype.factory.abstractfactory.Response;
import com.xxx.designpattern.createtype.factory.abstractfactory.product.Convert;

public abstract class ConvertFactory {

    abstract Convert<?, Request> createRequestConvert();

    abstract Convert<Response,?> createResponseConvert();

}

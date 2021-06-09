package com.xxx.designpattern.factory.abstractfactory.factory;

import com.xxx.designpattern.factory.abstractfactory.Request;
import com.xxx.designpattern.factory.abstractfactory.Response;
import com.xxx.designpattern.factory.abstractfactory.product.Convert;

public abstract class ConvertFactory {

    abstract Convert<?, Request> createRequestConvert();

    abstract Convert<Response,?> createResponseConvert();

}

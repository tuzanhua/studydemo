package com.xxx.designpattern.createtype.factory.abstractfactory.product;

public interface Convert<T, R> {
    R convert(T t);
}

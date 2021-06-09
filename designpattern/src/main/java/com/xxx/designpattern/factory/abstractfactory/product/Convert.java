package com.xxx.designpattern.factory.abstractfactory.product;

public interface Convert<T, R> {
    R convert(T t);
}

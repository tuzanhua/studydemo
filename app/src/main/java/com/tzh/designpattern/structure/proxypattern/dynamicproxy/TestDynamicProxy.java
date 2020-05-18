package com.tzh.designpattern.structure.proxypattern.dynamicproxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        ConcreteTarget concreteTarget = new ConcreteTarget();
        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(concreteTarget);
        ITarget iTarget = dynamicProxyFactory.newInstance();
        iTarget.transferParams(5,6);
    }
}

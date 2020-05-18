package com.tzh.designpattern.structure.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class DynamicProxyFactory {
    private ConcreteTarget concreteTarget;

    public DynamicProxyFactory(ConcreteTarget concreteTarget) {
        this.concreteTarget = concreteTarget;
    }

    public ITarget newInstance(){
        return (ITarget) Proxy.newProxyInstance(concreteTarget.getClass().getClassLoader(), concreteTarget.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(concreteTarget, args);
                        System.out.println(invoke.toString());
                        return invoke;
                    }
                });
    }
}

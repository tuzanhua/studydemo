package com.tzh.designpattern.proxypattern.dynamicproxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class ConcreteTarget implements ITarget{
    @Override
    public String transferParams(int a, int b) {
        System.out.println("不执行这里");
        return String.valueOf(a + b);
    }
}

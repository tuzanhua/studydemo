package com.tzh.designpattern.proxypattern.staticproxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class ProxyTest {
    public static void main(String[] args) {
        TargetSubject targetSubject = new TargetSubject();
        ProxySubject proxySubject = new ProxySubject(targetSubject);
        proxySubject.teachMath();
    }
}

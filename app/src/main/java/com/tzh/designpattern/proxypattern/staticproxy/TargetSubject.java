package com.tzh.designpattern.proxypattern.staticproxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class TargetSubject implements Subject{

    @Override
    public void teachMath() {
        System.out.println("真正的subject  开始工作了");
    }
}

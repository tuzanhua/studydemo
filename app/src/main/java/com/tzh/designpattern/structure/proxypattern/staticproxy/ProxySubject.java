package com.tzh.designpattern.structure.proxypattern.staticproxy;

/**
 * create by tuzanhua on 2020/4/21
 */
public class ProxySubject implements Subject {

    private TargetSubject targetSubject;

    public ProxySubject(TargetSubject targetSubject) {
        this.targetSubject = targetSubject;
    }

    @Override
    public void teachMath() {
        System.out.println("在你教课之前我先插播一段广告");
        targetSubject.teachMath();
        System.out.println("好了你教完课了 我仍然要进行广告的插播");
    }
}

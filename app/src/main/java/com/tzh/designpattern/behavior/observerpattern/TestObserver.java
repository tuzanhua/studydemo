package com.tzh.designpattern.behavior.observerpattern;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TestObserver {

    public static void main(String[] args) {
        Observable observable = new Observable();

        observable.registObserver(data -> System.out.println("第一个更新了:" + data));

        observable.registObserver(data -> System.out.println("第二个更新了:" + data));

        observable.registObserver(data -> System.out.println("第三个更新了:" + data));

        observable.notifyDataChanged("  天气上升到 50度了");

    }

}

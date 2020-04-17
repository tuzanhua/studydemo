package com.tzh.designpattern.strategy;

/**
 * create by tuzanhua on 2020/4/16
 */
public class BStrategy extends IStrategy {
    @Override
    public int getCost() {
        return 2;
    }

    @Override
    public void showBehaviour() {
        System.out.println("B Behaviour");

    }
}

package com.tzh.designpattern.behavior.strategy;

/**
 * create by tuzanhua on 2020/4/16
 */
public class AStrategy extends IStrategy {

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    public void showBehaviour() {
        System.out.println("A behaviour");
    }
}

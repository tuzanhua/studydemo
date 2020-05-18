package com.tzh.designpattern.behavior.strategy;

/**
 * create by tuzanhua on 2020/4/16
 */
public class TestStrategy {
    public static void main(String[] args) {
        IStrategy iStrategy = new AStrategy();
        StrategyContext strategyContext  = new StrategyContext(iStrategy);
        int cost = strategyContext.getCost();
        System.out.println("cost :" + cost);
       strategyContext.show();

    }
}

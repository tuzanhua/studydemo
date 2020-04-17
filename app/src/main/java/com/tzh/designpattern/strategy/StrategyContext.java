package com.tzh.designpattern.strategy;

/**
 * create by tuzanhua on 2020/4/16
 */
public class StrategyContext {

    private IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int getCost(){
        return strategy.getCost();
    }

    public void show(){
        strategy.showBehaviour();
    }
}

package com.tzh.designpattern.decoratorpattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class DecoratorMilkCoffee extends CoffeeComponent {

    private CoffeeComponent coffeComponent;

    public DecoratorMilkCoffee(CoffeeComponent coffeComponent) {
        this.coffeComponent = coffeComponent;
    }

    @Override
    double cost() {
        return coffeComponent.cost() + 1.5;
    }
}

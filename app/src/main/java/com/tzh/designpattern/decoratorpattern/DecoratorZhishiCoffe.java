package com.tzh.designpattern.decoratorpattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class DecoratorZhishiCoffe extends CoffeeComponent {

    private CoffeeComponent coffeComponent;

    public DecoratorZhishiCoffe(CoffeeComponent coffeComponent) {
        this.coffeComponent = coffeComponent;
    }

    @Override
    double cost() {
        return coffeComponent.cost() + 2.0;
    }
}

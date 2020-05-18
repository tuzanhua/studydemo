package com.tzh.designpattern.structure.decoratorpattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeComponent coffeComponent = new ConcreteComponentMokaCoffee();

        coffeComponent = new DecoratorMilkCoffee(coffeComponent);

        coffeComponent = new DecoratorZhishiCoffe(coffeComponent);
        System.out.println(coffeComponent.cost());
    }
}

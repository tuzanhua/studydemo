package com.xxx.designpattern.structuraltype.decorator;

public class DecoratorClient {

    public static void main(String[] args) {
        IComponent component = new ConcreteComponent();
        ConcreteDecoratorComponentA decoratorComponentA = new ConcreteDecoratorComponentA(component);
        decoratorComponentA.behaviour();
        component = new ConcreteDecoratorComponentB(decoratorComponentA);
        component.operation();
    }

}

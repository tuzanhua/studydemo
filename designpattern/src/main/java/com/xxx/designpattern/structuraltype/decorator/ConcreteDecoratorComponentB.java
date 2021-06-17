package com.xxx.designpattern.structuraltype.decorator;

public class ConcreteDecoratorComponentB extends DecoratorComponent {
    public ConcreteDecoratorComponentB(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println(",我给你添加了一些色素让你看起来更有食欲");
    }

}

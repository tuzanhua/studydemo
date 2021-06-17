package com.xxx.designpattern.structuraltype.decorator;

public class ConcreteDecoratorComponentA extends DecoratorComponent {
    public ConcreteDecoratorComponentA(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println(",我给你添加了一些糖");
    }

    public void behaviour(){
        System.out.println("我是糖果大王这是我独有的行为");
    }
}

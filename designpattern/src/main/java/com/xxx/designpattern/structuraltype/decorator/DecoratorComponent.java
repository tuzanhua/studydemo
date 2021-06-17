package com.xxx.designpattern.structuraltype.decorator;

public abstract class DecoratorComponent implements IComponent {

    protected IComponent component;

    public DecoratorComponent(IComponent component) {
        this.component = component;
    }



}

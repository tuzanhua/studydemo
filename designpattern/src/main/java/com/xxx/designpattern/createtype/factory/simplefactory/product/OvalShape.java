package com.xxx.designpattern.createtype.factory.simplefactory.product;

public class OvalShape implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }
}

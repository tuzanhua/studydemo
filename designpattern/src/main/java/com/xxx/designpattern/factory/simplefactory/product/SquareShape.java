package com.xxx.designpattern.factory.simplefactory.product;

public class SquareShape implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制正方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除正方形");
    }
}

package com.xxx.designpattern.createtype.factory.simplefactory.product;

public class TriangleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }

    @Override
    public void erase() {
        System.out.println("擦除三角形");
    }
}

package com.xxx.designpattern.factory.simplefactory;

import com.xxx.designpattern.factory.simplefactory.factory.ShapeFactoryImpl;
import com.xxx.designpattern.factory.simplefactory.product.Shape;

public class ShapeClient {

    public static void main(String[] args) {
        Shape shape = ShapeFactoryImpl.createShape(ShapeFactoryImpl.ShapeStr.oval);
        shape.draw();
        shape.erase();


    }
}

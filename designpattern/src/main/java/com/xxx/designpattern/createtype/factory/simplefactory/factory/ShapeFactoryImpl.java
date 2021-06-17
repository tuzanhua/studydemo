package com.xxx.designpattern.createtype.factory.simplefactory.factory;

import com.xxx.designpattern.createtype.factory.simplefactory.product.OvalShape;
import com.xxx.designpattern.createtype.factory.simplefactory.product.Shape;
import com.xxx.designpattern.createtype.factory.simplefactory.product.SquareShape;
import com.xxx.designpattern.createtype.factory.simplefactory.product.TriangleShape;
import com.xxx.designpattern.createtype.factory.simplefactory.UnSupportedShapeException;

public class ShapeFactoryImpl implements IShapeFactory {

    public static Shape createShape(ShapeStr shape){
        if ("oval".equals(shape.name())){
            return new OvalShape();
        }else if ("square".equals(shape.name())){
            return new SquareShape();
        }else if ("triangle".equals(shape.name())){
            return new TriangleShape();
        }else {
            throw new UnSupportedShapeException("unSupportedShape exception");
        }
    }

   public static enum ShapeStr{
        oval,square,triangle
    }
}

package com.xxx.designpattern.createtype.factory.simplefactory;

public class UnSupportedShapeException extends RuntimeException {

    public UnSupportedShapeException(String exception) {
      super(exception);
    }

}

package com.xxx.designpattern.factory.simplefactory;

public class UnSupportedShapeException extends RuntimeException {

    public UnSupportedShapeException(String exception) {
      super(exception);
    }

}

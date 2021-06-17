package com.xxx.designpattern.structuraltype.bridge;

public class Client {
    public static void main(String[] args) {
        Pen pen = new RefinedPenMaoBi();
        pen.setPenPointTypeImp(new ConcreteImplementorPenImpl());
        pen.paint("hello world");
    }
}

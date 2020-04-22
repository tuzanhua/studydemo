package com.tzh.designpattern.bridgepattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class BridgeTest {
    public static void main(String[] args) {

        IComputer computer = new TaiShiComputer(new AppleBrand());
        System.out.println(computer.name());
    }
}

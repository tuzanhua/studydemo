package com.tzh.designpattern.bridgepattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class TaiShiComputer implements IComputer {
    private IBrand brand;

    public TaiShiComputer(IBrand brand) {
        this.brand = brand;
    }

    @Override
    public String info() {
        return brand.brandName() + "台式电脑";
    }
}

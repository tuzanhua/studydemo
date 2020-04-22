package com.tzh.designpattern.bridgepattern;

/**
 * create by tuzanhua on 2020/4/21
 */
public class BijibenComputer implements IComputer {

    private IBrand brand;

    public BijibenComputer(IBrand brand) {
        this.brand = brand;
    }

    @Override
    public String info() {
        return brand.brandName() + "笔记本电脑";
    }
}

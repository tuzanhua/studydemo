package com.tzh.designpattern.adapterpattern;

/**
 * create by tuzanhua on 2020/4/20
 */
public class V5Desc implements IVPolicy{
    private V220Target target;

    public V5Desc(V220Target target) {
        this.target = target;
    }

    @Override
    public int toV5() {
        int i = target.dianya() / 44;
        return i;
    }
}

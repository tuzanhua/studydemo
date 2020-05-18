package com.tzh.designpattern.structure.adapterpattern;

/**
 * create by tuzanhua on 2020/4/20
 */
public class TestAdapter {
    public static void main(String[] args) {

        Phone phone = new Phone();
        V220Target v220Target = new V220Target();
        phone.setAdapter(new V5Desc(v220Target));

    }
}

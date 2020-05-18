package com.tzh.designpattern.structure.adapterpattern;

/**
 * create by tuzanhua on 2020/4/20
 */
public class Phone {

    public void setAdapter(IVPolicy ivPolicy){
        int i = ivPolicy.toV5();
        System.out.println("开始充电了 :" + i);
    }

}

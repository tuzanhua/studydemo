package com.xxx.designpattern.structuraltype.adapter.objectadapter;

/**
 * 被改造者,这里一般情况是已经写好的类 别的地方需要使用到但是又不能修改这里面的源代码
 */
public class Adaptee {

    public void sort(int[] arr) {
        // 排序操作
    }

    public int search(int arr[], int value) {
        return -1;
    }
}

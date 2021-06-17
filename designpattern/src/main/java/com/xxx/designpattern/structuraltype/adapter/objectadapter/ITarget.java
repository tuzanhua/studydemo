package com.xxx.designpattern.structuraltype.adapter.objectadapter;

/**
 * 定义的逻辑接口 需要别人来适配
 */
public interface ITarget {

    void sort(int[] arr);

    /**
     * 差找分数对应的名次
     */
    int search(int[] arr,int score);

}

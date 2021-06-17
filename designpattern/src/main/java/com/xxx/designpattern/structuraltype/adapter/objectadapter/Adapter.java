package com.xxx.designpattern.structuraltype.adapter.objectadapter;

public class Adapter implements ITarget {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sort(int[] arr) {
       adaptee.sort(arr);
    }

    @Override
    public int search(int[] arr, int score) {
        return adaptee.search(arr,score);
    }
}

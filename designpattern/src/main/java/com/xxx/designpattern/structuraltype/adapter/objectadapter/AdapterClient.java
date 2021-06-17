package com.xxx.designpattern.structuraltype.adapter.objectadapter;

public class AdapterClient {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Adapter adapter = new Adapter(new Adaptee());
        adapter.sort(arr);
        adapter.search(arr, 3);
    }
}

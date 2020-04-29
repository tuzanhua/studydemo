package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class TestLinkedList {

    public static void main(String[] args) {
        TSingleLinkedList<Integer> integerTSingleLinkedList = new TSingleLinkedList<>();
        integerTSingleLinkedList.add(1);
        integerTSingleLinkedList.add(2);
        integerTSingleLinkedList.add(3);
        integerTSingleLinkedList.add(4);
        integerTSingleLinkedList.add(5);
        System.out.println(integerTSingleLinkedList.toString());

        Integer integer = integerTSingleLinkedList.get(2);
        System.out.println(integer + "");

        integerTSingleLinkedList.remove(2);
        System.out.println(integerTSingleLinkedList.toString());

        int i = integerTSingleLinkedList.indexOf(4);
        System.out.println(i + "");
    }
}

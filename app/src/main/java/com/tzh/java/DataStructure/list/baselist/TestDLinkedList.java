package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class TestDLinkedList {
    public static void main(String[] args) {
        TDoubleLinkedList<Integer> integerTDoubleLinkedList = new TDoubleLinkedList<>();
        integerTDoubleLinkedList.add(1);
        integerTDoubleLinkedList.add(2);
        integerTDoubleLinkedList.add(3);
        integerTDoubleLinkedList.add(4);
        integerTDoubleLinkedList.add(5);

        System.out.println(integerTDoubleLinkedList.getFirst());
        System.out.println(integerTDoubleLinkedList.getLast());
        System.out.println(integerTDoubleLinkedList.toString());

        integerTDoubleLinkedList.remove(2);
        System.out.println(integerTDoubleLinkedList.toString());
    }
}

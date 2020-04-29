package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class ListNode<E> {

    E element;
    ListNode<E> next;

    public ListNode(E element, ListNode<E> next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "element=" + element.toString() +
                ", next=" + next.element +
                '}';
    }
}

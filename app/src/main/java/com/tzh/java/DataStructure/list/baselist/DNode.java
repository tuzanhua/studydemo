package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class DNode<E> {

    DNode<E> pre;
    E element;
    DNode<E> next;

    public DNode(DNode<E> pre, E element, DNode<E> next) {
        this.pre = pre;
        this.element = element;
        this.next = next;
    }
}

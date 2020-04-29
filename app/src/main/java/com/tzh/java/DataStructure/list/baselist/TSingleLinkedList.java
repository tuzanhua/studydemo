package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class TSingleLinkedList<E> {

    private ListNode<E> first;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if (index == 0) {
            first = new ListNode<>(element, null);
        } else {
            ListNode<E> node = node(index - 1);
            node.next = new ListNode<>(element, null);
        }
        size++;
    }

    public E get(int index) {
        ListNode<E> node = node(index);
        return node.element;
    }

    public E remove(int index) {
        ListNode<E> node = node(index - 1);
        E oldElement = node.next.element;
        node.next = node.next.next;
        size--;
        return oldElement;
    }


    public int indexOf(E e) {
        ListNode<E> node = first;
        for (int i = 0; i < size; i++) {
            ListNode<E> node1 = node(i);
            if (node1.element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private ListNode<E> node(int index) {
        ListNode<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                builder.append(node(i).element);
            } else {
                builder.append(",").append(node(i).element);
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

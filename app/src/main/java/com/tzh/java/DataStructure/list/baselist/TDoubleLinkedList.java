package com.tzh.java.DataStructure.list.baselist;

/**
 * create by tuzanhua on 2020/4/29
 */
public class TDoubleLinkedList<E> {
    private int size;
    private DNode<E> first;
    private DNode<E> last;

    public TDoubleLinkedList() {
        first = last;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        add(size, e);
    }

    public void add(int index, E element) {
        if (index == size) {
            if (size == 0) {
                first = last = new DNode<>(null, element, null);
            } else {
                last.next = new DNode<>(last, element, null);
                last = last.next;
            }
        } else {
            DNode<E> node = node(index);
            DNode<E> pre = node.pre;
            DNode<E> edNode = new DNode<>(pre, element, node);
            pre.next = edNode;
            node.pre = edNode;
        }
        size++;
    }

    public E get(int index) {
        return node(index).element;
    }

    public E remove(int index) {
        DNode<E> node = node(index);
        DNode<E> pre = node.pre;
        DNode<E> next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
        return node.element;
    }


    public E getFirst() {
        return first.element;
    }

    public E getLast() {
        return last.element;
    }

    private DNode<E> node(int index) {
        DNode<E> node;
        if (index > size >> 1) {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
        } else {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
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

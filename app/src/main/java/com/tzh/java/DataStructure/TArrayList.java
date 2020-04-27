package com.tzh.java.DataStructure;

/**
 * create by tuzanhua on 2020/4/27
 * <p>
 * 首先想 设计一个 数组结构实现的链表 需要对外界暴露的方法
 * add()
 * get()
 * indexOf()
 * isEmpty()
 * size()
 * remove()
 */
public class TArrayList<E> {

    public static void main(String[] args) {
        TArrayList<String> stringTArrayList = new TArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringTArrayList.add(i + "个数据");
        }

        System.out.println("size : " + stringTArrayList.size);

        stringTArrayList.remove(15);
        for (int i = 0; i < stringTArrayList.size; i++) {
            System.out.println(stringTArrayList.get(i));
        }
    }
    
    private int size;

    private Object[] elememts;

    private static final int DEFAULT_CAPACITY = 10;

    public TArrayList(int capacity) {
        if (capacity < 0) {
            capacity = DEFAULT_CAPACITY;
        }
        elememts = new Object[capacity];
    }

    public TArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E e) {
        // 要判断 能不能继续添加数据  当前数组的长度是多少
        ensureCapacity();
        elememts[size] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size + 1 > elememts.length) {
            // 扩容
            int newCapacity = elememts.length + (elememts.length >> 2); // 1.5 倍
            Object[] newElememts = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElememts[i] = elememts[i];
            }
            elememts = newElememts;
        }
    }

    public E get(int index) {
        return indexOf(index);
    }

    public E indexOf(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size = " + size + "you need index is :" + index);
        }
        return (E) elememts[index];
    }

    public E remove(int index) {
        // remove 需要将移除位置,后面的数据整体向前移动补位  需要 index +1 -> size-1位置的数据前移
        E oldElememt = (E) elememts[index];
        for (int i = index + 1; i < size; i++) {
            elememts[i - 1] = elememts[i];
        }
        elememts[size - 1] = null;
        size--;
        return oldElememt;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}

package com.tzh.java.DataStructure;

/**
 * create by tuzanhua on 2020/4/15
 */
public class LinkListDemo {

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

//
//        Node temp = a;
//        a.next = null;
//        System.out.println(temp.data + "  " + temp.next);

//        Node reverse = reverse(a);
        Node reverse = reverseDiGui(a);
//        while (reverse != null) {
//            System.out.println(reverse.data + ",");
//            reverse = reverse.next;
//        }
    }

    /**
     * 利用辅助字段实现
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {

        Node pre = null;
        Node temp = null;
        while (head != null) {
            temp = head.next; //创建变量 防止断链
            head.next = pre; //将当前节点的下一个节点 指向上一次 的节点
            pre = head;      // 给下一次循环使用
            head = temp;     // 开启下一次循环
        }
        return pre;
    }

    /**
     * 这个方法我不理解 需要好好学习
     *
     * @param head
     * @return
     */
    // a-> b -> c -> d
    public static Node reverseDiGui(Node head) {
        //退出递归条件 head == null
        if (head.next == null) {
            return head;
        }
        //d
        Node newNode = reverseDiGui(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}

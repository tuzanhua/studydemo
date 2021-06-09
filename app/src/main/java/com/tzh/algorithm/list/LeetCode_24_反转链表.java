package com.tzh.algorithm.list;

/**
 * create by tuzanhua on 2020/4/29
 * <p>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5
 * 输出: 5->4->3->2->1
 */
public class LeetCode_24_反转链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseList(node1);
        show(node);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // 出口
            return head;
        }

        ListNode tailNode = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return tailNode;
    }

    public static ListNode reverseList1(ListNode head) {

        ListNode preNode = null;

        while (head != null) {
            // temp
            ListNode temp = head.next;
            //转移链
            head.next = preNode;
            // 赋值
            preNode = head;
            //循环
            head = temp;
        }

        return preNode;
    }

    public static void show(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

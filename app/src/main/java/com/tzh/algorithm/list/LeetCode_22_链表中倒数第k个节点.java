package com.tzh.algorithm.list;

import java.util.List;

/**
 * create by tuzanhua on 2020/4/29
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 解题思路  1: 先遍历获取 list size
 * 2: 双指针 让他们相差 K 步
 */
public class LeetCode_22_链表中倒数第k个节点 {
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
        ListNode kthFromEnd = getKthFromEnd2(node1, 2);
        show(kthFromEnd);
    }

    public static void show(ListNode node) {
        ListNode node1 = node;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    /**
     * 第一种解法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        int m = size - k;
        ListNode node = head;
        for (int i = 0; i < m; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 第二种方法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode laterNode;
        ListNode preKNode;
        laterNode = preKNode = head;
        // 让pre node 先走k
        for (int i = 0; i < k; i++) {
            preKNode = preKNode.next;
        }

        while (preKNode != null) {
            preKNode = preKNode.next;
            laterNode = laterNode.next;
        }


        return laterNode;
    }
}

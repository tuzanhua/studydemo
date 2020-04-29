package com.tzh.algorithm.tarray;

import java.util.Arrays;

/**
 * create by tuzanhua on 2020/4/29 
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class leetcode_88合并两个有序数组 {

    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] num2 = {1, 2, 3};
        int n = 3;
        merge(num1, m, num2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] <= nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
            System.out.println("p =" + p +"      p2:" + p2);
        }

        System.out.println(Arrays.toString(nums1));
    }
}

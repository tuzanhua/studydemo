package com.tzh.algorithm.tarray;

import java.util.HashMap;

/**
 * create by tuzanhua on 2020/4/10
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * <p>
 * 难度等级 easy
 * <p>
 * int[] nums = {4,23,4,90}; target = 6
 */
public class TwoNumSumInArray {

    public static void main(String[] args) {
        int[] arr = {4, 8, 4, 6};
        int target = 8;
        int[] twoNum = getTwoNum(arr, target);
        printValues(twoNum);

        int[] twoSumByHash = getTwoSumByHash(arr, target);
        printValues(twoSumByHash);

        printValues(getTwoNum2(arr, target));
    }

    /**
     * 暴力算法  经过两个 for 循环就可以计算出 时间复杂度 0(n^2)
     */
    public static int[] getTwoNum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == target - arr[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("can find two num");
    }

    /**
     * 使用hashMap 减小时间复杂度 0(n)
     */
    public static int[] getTwoSumByHash(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{map.get(diff), i};
            }
        }
        throw new IllegalArgumentException("can find two num");
    }

    /**
     * 对第二种解法的进一步优化 可以一次遍历完成计算任务
     */
    public static int[] getTwoNum2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("can find two num");
    }

    public static void printValues(int[] arr) {
        System.out.println("[ " + arr[0] + "," + arr[1] + " ]");
    }

}

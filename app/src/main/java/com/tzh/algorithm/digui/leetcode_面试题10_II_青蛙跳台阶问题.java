package com.tzh.algorithm.digui;

import java.util.HashMap;

/**
 * create by tuzanhua on 2020/5/19
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class leetcode_面试题10_II_青蛙跳台阶问题 {
    HashMap<Integer, Integer> cluCount = new HashMap<>();

    public int numWays(int n) {

        if (n <= 1) {
            return 1;
        }

        if (cluCount.containsKey(n)) {
            return cluCount.get(n);
        } else {
            int k = (numWays(n - 1) + numWays(n - 2)) % 1000000007; // 保证数据是int 值
            cluCount.put(n, k);
            return k;
        }
    }

    public int numWays1(int n) {
        int a = 1;
        int b = 1;
        int sum = a;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
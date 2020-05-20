package com.tzh.algorithm.digui;

/**
 * create by tuzanhua on 2020/5/19
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 */
public class leetcode_680_验证回文字符串_Ⅱ {

    public static void main(String[] args) {
        String s = "cbbcc";
        boolean b = validPalindrome(s);
        System.out.println("b  " + b);
    }

    public static boolean validPalindrome(String s) {

        // 解题思路双指针
        // 如果遇到 不是回文数的 那么我们可以删除左边一个 或者右边一个来判断剩下的数据是不是回文数

        int low = 0;
        int hight = s.length() - 1;

        while (low < hight) {
            if (s.charAt(low) == s.charAt(hight)) {
                low++;
                hight--;
            } else {
                boolean flag1 = true, flag2 = true;
                int low1 = low + 1;
                int hight1 = hight;
                while (low1 < hight1) {
                    if (s.charAt(low1) == s.charAt(hight1)) {
                        low1++;
                        hight1--;
                    } else {
                        flag1 = false;
                        break;
                    }
                }
                int low2 = low;
                int high2 = hight - 1;
                while (low2 < high2) {
                    if (s.charAt(low2) == s.charAt(high2)) {
                        low2++;
                        high2--;
                    } else {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}

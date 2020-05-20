package com.tzh.algorithm.array;

/**
 * create by tuzanhua on 2020/5/19
 * <p>
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class leetcode_674_最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int anchor = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                anchor++;
            } else {
                anchor = 1;
            }
            ans = ans > anchor ? ans : anchor;
        }
        return ans;
    }
}

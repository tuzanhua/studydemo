package com.tzh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * create by tuzanhua on 2020/5/19
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 */
public class leetcode_119_杨辉三角_II {
    // 输入 3 返回  1 3 3 1

    public List<Integer> getRow(int rowIndex) {
        //解题思路 需要记录上一层的 list
        if (rowIndex == 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            return integers;
        }
        List<Integer> target  = new ArrayList<>(rowIndex + 1);
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            target = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    target.add(1);
                }else{
                    target.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = target;
        }
        return target;
    }
}

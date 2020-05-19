package com.tzh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * create by tuzanhua on 2020/5/19
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class leetcode_1431_拥有最多糖果的孩子 {
//    输入：candies = [2,3,5,1,3], extraCandies = 3
//    输出：[true,true,true,false,true]

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> kids = new ArrayList<>();
        // 先找出 candies 里面的最大值

        int sum = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if(sum < candies[i]){
                sum = candies[i];
            }
        }

        // 获取到最大值 然后进行一一比对并设置 true false

        for(int i = 0;i<candies.length;i++){
            if(candies[i] >= sum){
                kids.add(true);
            }else{
                if(candies[i] + extraCandies >= sum){
                    kids.add(true);
                }else{
                    kids.add(false);
                }
            }
        }


        return kids;
    }
}

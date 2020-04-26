package com.tzh.java;

import java.util.Observable;

/**
 * create by tuzanhua on 2020/4/13
 * <p>
 * 程序实现 4 * 3 * 2 *1
 */
public class JieChengDemo {
    public static void main(String[] args) {
        int jieCheng = getJieCheng(5);
        System.out.println("value :" + jieCheng);
        System.out.println("value1 :" + getJieCheng1(5));

        Observable
    }

    /**
     * 递归实现
     */
    public static int getJieCheng(int num) {
        if (num == 1) {
            return 1;
        }
        return num * getJieCheng(num - 1);
    }

    public static int getJieCheng1(int num) {
        int sum = 1;
        for (int i = 1; i <= num; i++) {
             sum *= i;
        }
        return sum;
    }
}

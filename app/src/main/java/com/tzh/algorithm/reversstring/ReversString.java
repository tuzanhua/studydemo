package com.tzh.algorithm.reversstring;

/**
 * create by tuzanhua on 2020/4/20
 */
public class ReversString {
    // \\s+
    public static void main(String[] args) {
        String str = "I  LOVE     YOU";
        String[] s = str.split(" ");
        System.out.println(s.length);
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i]);
        }
        System.out.println("============");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println("============");
        String s1 = "1   4";
        String[] s2 = s1.split(" ");
        System.out.println(s2.length);

        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }
}

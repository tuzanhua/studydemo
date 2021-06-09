package com.tzh.algorithm.sort;

public class MaopaoSort {

    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 11, 77, 6, 8, 20,1};
        MaopaoSort maopaoSort = new MaopaoSort();
        maopaoSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }
    }

    public void sort(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int temp = arr[j];
                if (arr[j] > arr[j + 1]) {
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
    }
}

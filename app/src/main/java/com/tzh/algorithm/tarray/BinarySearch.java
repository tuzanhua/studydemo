package com.tzh.algorithm.tarray;

/**
 * create by tuzanhua on 2020/4/16
 * 二分查找 : 在一个有序的数组里面找到 对应数据的位置
 * 需要三个指针 left  mid right 循环查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 11, 21, 25, 30};
        int left = 0;
        int right = arr.length - 1;

        int i = binarySearch(arr, 3, left, right);
        System.out.println("position:" + i);
        System.out.println("=====================================================");

        System.out.println("position:" + binarySearch1(arr, 3));
    }

    /**
     * 递归实现
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            right = mid - 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            return mid;
        }
        return binarySearch(arr, target, left, right);
    }

    public static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

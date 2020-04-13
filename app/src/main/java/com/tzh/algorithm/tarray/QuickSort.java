package com.tzh.algorithm.tarray;

/**
 * create by tuzanhua on 2020/4/13
 * <p>
 * 参考博客: https://juejin.im/post/5b55660ee51d4519202e2003
 * 快速排序:采用分治的思想
 * 第一步 : 选取一个基准 数 将比它小的数据都放在它的左边 将比它大的都放在它的右边
 * 第二步 : 左右部分分别递归
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {20, 40, 2, 50, 12, 22, 50, 10, 2, 8, 19};

        qiuckSort(arr, 0, arr.length - 1);
        pritArr(arr);
    }

    public static void pritArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i] + ",");
        }
        builder.append("]");
        System.out.println(builder);
    }

    public static void qiuckSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        // 找到mid 位置
        int position = getPosition(arr, left, right);
        qiuckSort(arr, left, position);
        qiuckSort(arr, position + 1, right);

    }

    public static int getPosition(int[] arr, int left, int right) {
        // 采用三数中值分割法
        int mid = left + (right - left) / 2;
        // 保证左端较小
        if (arr[mid] > arr[left]) {
            int temp = arr[mid];
            arr[mid] = arr[left];
            arr[left] = temp;
        }
        //保证中间最小
        if (arr[mid] > arr[right]) {
            int temp = arr[right];
            arr[right] = arr[mid];
            arr[mid] = temp;
        }
        //保证左端比右端小
        if (arr[left] > arr[right]) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

        int pivot = arr[left];
        while (left < right) {

            // 先从右边找比 基准值小的值
            while (arr[right] >= pivot && left < right) {
                --right;
            }
            //当找到比基准值小的数据时候进行位置 互换
            if (left < right) {
                arr[left] = arr[right];
                ++left;
                // 此时右边数据没有更新 那么接下来需要处理右边坑位数据
            }

            // 从左边找到比基准值大的值
            while (arr[left] <= pivot && left < right) {
                ++left;
            }

            //当找到对应的值得时候 需要对 右侧坑位 进行填充   当右侧坑位填充之后 需要在填充左侧坑位
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }

        //当一轮循环结束  数据已经实现 左小右大了  但是还差一步  基准数据还没有放入对应的位置
        arr[left] = pivot;
        return left;

    }
}

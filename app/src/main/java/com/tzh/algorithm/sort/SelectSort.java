package com.tzh.algorithm.sort;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 11, 77, 6, 8, 20};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

//        Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
//                emitter.onNext();
//            }
//        }).subscribeOn()


    }

    public void sort(int[] arr) {
        int temp = 0, index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index > 0) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}

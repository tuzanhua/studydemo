package com.tzh.android.trxjava;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * create by tuzanhua on 2020/4/26
 */
public class RxJavaDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        for (Integer i : arrayList) {
            if (i == 3) {
                arrayList.remove(i);
                break;
            }
        }
        System.out.println(arrayList.size());
        @NonNull Observable<Object> objectObservable = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                System.out.println("开始执行线程 :" + Thread.currentThread().getName());
                emitter.onNext("开始发射1");
                emitter.onNext("开始发射2");
                emitter.onNext("开始发射3");
                emitter.onNext("开始发射4");
            }
        });
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext :" + o.toString());
                System.out.println("onNext执行线程 :" + Thread.currentThread().getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        objectObservable.subscribeOn(Schedulers.io())
                .subscribe(observer);

        objectObservable.map(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) throws Throwable {
                return null;
            }
        });
    }
}

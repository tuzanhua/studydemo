package com.tzh.android.trxjava.trx;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TRxTest {
    static int count = 100;

    public static void main(String[] args) {

        TObservable.create(new TObservable.TOnSubscribe<Object>() {
            @Override
            public void call(TSubscriber<? super Object> subscriber) {
                System.out.println("发射数据线程 :" + Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    subscriber.onNext("start emmit :" + i);
                }
            }
        }).map(new TObservable.Transformer<Object, Integer>() {
            @Override
            public Integer call(Object form) {
                return count++;
            }
        }).subscribeOn(TSchedulers.IO())
                .subscribe(new TSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer var) {
                        System.out.println("接收数据线程 :" + Thread.currentThread().getName());
                        System.out.println("接收数据 :" + var);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void omComplite() {

                    }
                });
    }
}

package com.tzh.android.trxjava.trx;

/**
 * create by tuzanhua on 2020/4/26
 */
public interface TObserver<T> {

    void onNext(T var);

    void onError(Throwable throwable);

    void omComplite();


}

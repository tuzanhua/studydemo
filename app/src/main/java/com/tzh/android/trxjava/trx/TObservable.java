package com.tzh.android.trxjava.trx;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TObservable<T> {

    private TOnSubscribe<T> tOnSubscribe;

    private TObservable(TOnSubscribe<T> tOnSubscribe) {
        this.tOnSubscribe = tOnSubscribe;
    }

    public static <T> TObservable<T> create(TOnSubscribe<T> tOnSubscribe) {
        return new TObservable<T>(tOnSubscribe);
    }

    public void subscribe(TSubscriber<? super T> tSubscriber) {
        tOnSubscribe.call(tSubscriber);
    }

    public interface TOnSubscribe<T> {
        void call(TSubscriber<? super T> subscriber);
    }

    public <R> TObservable<R> map(Transformer<? super T, ? extends R> transformer) {
        return create(new TOnSubscribe<R>() {
            @Override
            public void call(TSubscriber<? super R> subscriber) {
                TObservable.this.subscribe(new TSubscriber<T>() {
                    @Override
                    public void onNext(T var) {
                        subscriber.onNext(transformer.call(var));
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        subscriber.onError(throwable);
                    }

                    @Override
                    public void omComplite() {
                        subscriber.omComplite();
                    }
                });
            }
        });
    }

    public interface Transformer<T, R> {
        R call(T form);
    }

    // 线程切换
    public TObservable<T> subscribeOn(TScheduler tScheduler) {
        return create(new TOnSubscribe<T>() {
            @Override
            public void call(TSubscriber<? super T> subscriber) {
                tScheduler.createWorker().schedule(new Runnable() {
                    @Override
                    public void run() {
                        Thread.currentThread().setName("TRxSchedule Thread -----");
                        TObservable.this.tOnSubscribe.call(subscriber);
                    }
                });
            }
        });
    }
}

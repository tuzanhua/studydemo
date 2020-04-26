package com.tzh.android.trxjava.trx;

import java.util.concurrent.Executors;

/**
 * create by tuzanhua on 2020/4/26
 */
public class TSchedulers {

    private static TScheduler IO = new TScheduler(Executors.newCachedThreadPool());

    public static TScheduler IO() {
        return IO;
    }
}

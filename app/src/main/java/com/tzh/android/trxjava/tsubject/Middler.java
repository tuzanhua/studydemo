package com.tzh.android.trxjava.tsubject;

public interface Middler<T> {
    void call(Oberver<T> oberver);
}

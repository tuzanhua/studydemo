package com.tzh.android.trxjava.tsubject;

public class TObserverable<T> {

    private Middler<T> middler;

    private TObserverable(Middler<T> middler) {
        this.middler = middler;
    }

    public static <T> TObserverable<T> create(Middler<T> middler){
        return new TObserverable<>(middler);
    }

    public void subscribe(Oberver<T> oberver) {
        TObserverable.this.middler.call(oberver);
    }

}

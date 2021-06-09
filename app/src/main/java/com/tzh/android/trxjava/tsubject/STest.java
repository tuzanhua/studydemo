package com.tzh.android.trxjava.tsubject;

public class STest {
    public static void main(String[] args) {
        TObserverable.create(new Middler<String>(){
            @Override
            public void call(Oberver<String> oberver) {

            }
        }).subscribe(new Oberver<String>() {
            @Override
            public void onNext(String s) {

            }
        });
    }
}

package com.xxx.imgloader;

import android.app.Activity;

public class TestClient {

    public static void main(String[] args) {

        IImageLoader loader = GloaderFactory.create();
        loader.load(new Activity(),null);
    }
}

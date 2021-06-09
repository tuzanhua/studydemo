package com.xxx.imgloader;

public class GloaderFactory extends LoaderFactory {

    public static IImageLoader create() {
        return new GLoader();
    }
}

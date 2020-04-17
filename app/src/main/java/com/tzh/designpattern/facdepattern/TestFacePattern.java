package com.tzh.designpattern.facdepattern;

/**
 * create by tuzanhua on 2020/4/17
 */
public class TestFacePattern {

    public static void main(String[] args) {
        FaceEnter.Builder builder = new FaceEnter.Builder();
        FaceEnter build = builder.build();

        RequestSystem.Builder builder1 = new RequestSystem.Builder();
        builder1.addUrl("www.facepattern.com");
        System.out.println("start request");
        build.enqueue(builder1.build());
    }
}

package com.tzh.designpattern.facdepattern;

/**
 * create by tuzanhua on 2020/4/17
 */
public class ResponseSystem {

   private String rawResponse;

    public ResponseSystem(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String convertNeedType() {
        return rawResponse + " 转换成功了";
    }
}

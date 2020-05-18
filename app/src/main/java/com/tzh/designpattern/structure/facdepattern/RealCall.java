package com.tzh.designpattern.structure.facdepattern;

/**
 * create by tuzanhua on 2020/4/17
 */
public class RealCall implements Call {
    @Override
    public ResponseSystem execute(RequestSystem requestSystem) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseSystem("连接网络返回 你请求的数据 : " + requestSystem.getRequest());
    }
}

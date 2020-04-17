package com.tzh.designpattern.facdepattern;

/**
 * create by tuzanhua on 2020/4/17
 * 参考链接: https://www.cnblogs.com/java-my-life/archive/2012/05/02/2478101.html
 * <p>
 * 外观模式 : 对外界提供一个对 多个子系统的入口
 * 门面模式的优点：
 * <p>
 * 　　●　　松散耦合
 * <p>
 * 　　门面模式松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护。
 * <p>
 * 　　●　　简单易用
 * <p>
 * 　　门面模式让子系统更加易用，客户端不再需要了解子系统内部的实现，也不需要跟众多子系统内部的模块进行交互，只需要跟门面类交互就可以了。
 * <p>
 * 　　●　　更好的划分访问层次
 * <p>
 * 　　通过合理使用Facade，可以帮助我们更好地划分访问的层次。有些方法是对系统外的，有些方法是系统内部使用的。把需要暴露给外部的功能集中到门面中，这样既方便客户端使用，也很好地隐藏了内部的细节。
 */
public class FaceEnter {

    private FaceEnter(Builder builder) {

    }

    public void enqueue(RequestSystem requestSystem) {
        ResponseSystem request = requestSystem.request();
        System.out.println("请求结果是:" + request.convertNeedType());
    }


    public static class Builder {

        public FaceEnter build() {
            return new FaceEnter(this);
        }
    }

}

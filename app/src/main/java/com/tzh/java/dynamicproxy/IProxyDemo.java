package com.tzh.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by tuzanhua on 2020/4/26
 */
public class IProxyDemo {

    public static void main(String[] args) {
        IProxyDemo iProxyDemo = new IProxyDemo();
        iProxyDemo.show();

    }

    public static void show() {
        Class<IDemo> iDemoClass = IDemo.class;

        IDemo iDemo = (IDemo) Proxy.newProxyInstance(iDemoClass.getClassLoader(), new Class[]{iDemoClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("getData")) {
                    System.out.println("触发创建方法了");
                    RealCall<String> stringRealCall = new RealCall<>();
                    return stringRealCall;
                }
                return null;
            }
        });

        Call<String> data = iDemo.getData();  // 这里触发动态代理内部实现
        data.enque(new Callback<String>() {
            @Override
            public void success(String data) {
                System.out.println("拿到返回的数据了 :" + data);
            }
        });
    }
}

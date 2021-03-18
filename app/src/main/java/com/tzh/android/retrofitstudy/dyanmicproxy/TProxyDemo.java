package com.tzh.android.retrofitstudy.dyanmicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TProxyDemo {

    public static void main(String[] args) {
        TX tx = new MTXIml();

        TX tt = (TX) Proxy.newProxyInstance(TX.class.getClassLoader(), tx.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                Object[] b = (Object[]) method.invoke(tx, args);
                b[0] = "换成假电视机";
                b[1] = "换成坏的电冰箱";
                return b;
            }
        });

        Object[] shopping = tt.shopping(2000);
        System.out.println("" + shopping[0] + shopping[1]);
    }


    public static class MTXIml implements TX {
        @Override
        public Object[] shopping(int cost) {
            System.out.println("花了:" + cost + "買了好多東西");
            Object[] a = new Object[2];
            a[0] = "电视机";
            a[1] = "电冰箱";
            return a;
        }
    }

    public interface TX {

        Object[] shopping(int cost);
    }
}

package com.tzh.java.dynamicproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TProxDemo {

    public static void main(String[] args) {
        try {
            Class<?> claz =  Class.forName("com.tzh.java.dynamicproxy.Person");
            Constructor<?> declaredConstructor = claz.getDeclaredConstructor();
            Object obj = declaredConstructor.newInstance();

            Field name = claz.getDeclaredField("name1");
            name.setAccessible(true);
            name.set(obj,"小明");
            System.out.println("name :" + obj.toString());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error :" +e.getMessage());
        }
    }



}

 class Person{
    private String name1;

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name1 + '\'' +
                 '}';
     }
 }

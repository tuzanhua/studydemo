package com.tzh.java.reflectstudy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by tuzanhua on 2020/4/26
 */
public class ReflectDemo {

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();  // 所有 public 方法包括父类的
        for (Method method : methods) {
            System.out.println("getMethods :  " + method.getName());
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();  // 当前类声明的所有方法
        for (Method method : declaredMethods) {
            System.out.println("getDeclaredMethods :  " + method.getName());
        }

        try {
            Class<?> aClass = Class.forName("com.tzh.java.reflectstudy.Person");
            Object o = aClass.newInstance();
            Method setName = aClass.getDeclaredMethod("setName", String.class);
            setName.invoke(o, "你好");

            System.out.println(o.toString());

            Class<?> aClass1 = Class.forName("com.tzh.java.reflectstudy.ReflectDemo$InnerClass");
            Method showInner = aClass1.getDeclaredMethod("showInner");
            showInner.setAccessible(true);
            showInner.invoke(aClass1.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static class InnerClass {
        private void showInner() {
            System.out.println("inner class");
        }
    }
}



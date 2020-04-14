package com.tzh.java;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * create by tuzanhua on 2020/4/13
 */
public class WeakRefrenceDemo {

    public static void main(String[] args) {

        Person person = new Person();
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        WeakReference<Person> weakReference = new WeakReference<Person>(person, referenceQueue);
        System.out.println(weakReference.get());
        int i = 1;
        while (true) {
            System.out.println(person.name);
            if (weakReference.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakReference.get());
            } else {
                System.out.println("Object is alive for " + i + " loops - null");
                break;
            }
        }
    }

    public static class Person {
        String name = "效力";
    }
}
//    public static void main(String args[]) {
//        final int size = 3;
//        List<WeakReference<DBConnection>> weakList = new ArrayList<WeakReference<DBConnection>>();
//        for (int i = 0; i < size; i++) {
//            DBConnection dbConnection = new DBConnection("DBConnection-" + i);
//            weakList.add(new WeakReference(dbConnection));
//            System.out.println(dbConnection + " be created.");
//        }
//        checkDBConnection(weakList);
//        quietlySleep(20000); // 休眠时间调整到你有足够时间在gc之前输入命令 jmap -histo:live <pid> >beforegc.txt，并能在gc之前完成信息收集
//        System.gc();                   // 不要通过在这里打断点来执行jmap命令，当暂停到断点时，jmap命令也会暂停执行，断点恢复后，会分不清jsmp收集的是GC前还是GC后的信息
//        System.out.println("gc be called.");
//        quietlySleep(1000); // 这里占用内存少，很快就回收了，占用内存大的就多给点时间
//        checkDBConnection(weakList);   // 这里可以打个断点，以让你知道可以输入命令 jmap -histo:live <pid> >aftergc.txt
//        quietlySleep(1000); // 休眠时间调整到在程序退出前有足够时间完成信息收集
//    }
//
//    // 检查DBConnection是否被垃圾回收
//    private static void checkDBConnection(List<WeakReference<DBConnection>> weakList) {
//        for (WeakReference<DBConnection> ref : weakList) {
//            DBConnection dbConnection = ref.get();
//            System.out.println("dbConnection is null ? " + (dbConnection == null));
//        }
//    }
//
//    // 让我安静睡会
//    private static void quietlySleep(long timeMillis) {
//        try {
//            Thread.sleep(timeMillis);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}
//
//// 模拟数据库连接资源
//class DBConnection {
//    public String id;
//
//    public DBConnection(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return id;
//    }
//}


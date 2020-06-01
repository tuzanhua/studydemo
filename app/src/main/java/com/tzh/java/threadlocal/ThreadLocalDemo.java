package com.tzh.java.threadlocal;


/**
 *   Thread ----   有 threadLocals = new ThreadLocalMap()
 *   ThreadLocal {@link ThreadLocal}
 *   public void set(T value) {
 *   // 先看当前 threadLocals 有没有创建 threadLocalMap
 *         Thread t = Thread.currentThread();
 *         ThreadLocalMap map = getMap(t);
 *         // 如果已经创建了
 *         if (map != null)
 *          //将自己作为key
 *             map.set(this, value);
 *         else
 *         //如果没有  创建 threadLocalMap 并赋值给 Thread 并将自己作为key 存储
 *             createMap(t, value);
 *     }
 *
 *      void createMap(Thread t, T firstValue) {
 *         t.threadLocals = new ThreadLocalMap(this, firstValue);
 *     }
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

       Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("first thread value");

                try {
                    Thread.sleep(2000);
                    String s = threadLocal.get();
                    System.out.println(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       thread.setName("first ");
       thread.start();

        Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("second thread value");

                try {
                    Thread.sleep(2000);
                    String s = threadLocal.get();
                    System.out.println(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("second ");
        thread1.start();
    }
}

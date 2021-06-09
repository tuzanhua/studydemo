package com.tzh.java.thread;


import java.util.concurrent.SynchronousQueue;

public class BlockQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();


        new Thread(new Runnable() {
            @Override
            public void run() {

                    try {
                        System.out.println("put  name1");
                        queue.put("name1");
                        System.out.println("put  name2");
                        queue.put("name2");
                        System.out.println("put  name2  end");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
System.out.println("执行结束了吗1线程");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                        String take = queue.take();
                        System.out.println("take" + take);

                    String take1 = queue.take();
                    System.out.println("take1" + take1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("执行结束了吗2线程");
            }
        }).start();


    }
}

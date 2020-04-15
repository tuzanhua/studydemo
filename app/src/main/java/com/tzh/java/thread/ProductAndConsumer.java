package com.tzh.java.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by tuzanhua on 2020/4/15
 * 生产者消费者模式 多对多  必须保证使用同一把锁
 */
public class ProductAndConsumer {

    public static void main(String[] args) {
//        Product product = new Product();
//        Producter producter = new Producter(product);
//        Consumer consumer = new Consumer(product);
//
//        new Thread(producter).start();
//        new Thread(producter).start();
//        new Thread(producter).start();
//        new Thread(consumer).start();
//        new Thread(consumer).start();
//        new Thread(consumer).start();
//        new Thread(consumer).start();
        TLinkedBlockQueue<String> stringTLinkedBlockQueue = new TLinkedBlockQueue<>();

        Producter1 producter1 = new Producter1(stringTLinkedBlockQueue);
        Consumer1 consumer1 = new Consumer1(stringTLinkedBlockQueue);

        Thread thread = new Thread(producter1);
        thread.setName("生一");
        Thread thread2 = new Thread(producter1);
        thread2.setName("生二");
        Thread thread3 = new Thread(producter1);
        thread3.setName("生三");

        thread.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread c1 = new Thread(consumer1);
        Thread c2 = new Thread(consumer1);
        Thread c3 = new Thread(consumer1);
        c1.setName("消一");
        c2.setName("消二");
        c3.setName("消三");

        c1.start();
        c2.start();


    }

    // 使用Synchronized
    static class Producter implements Runnable {

        private Product product;

        public Producter(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (true) {
                product.product();
            }
        }
    }

    static class Consumer implements Runnable {
        private Product product;

        public Consumer(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (true) {
                product.consumer();
            }
        }
    }


    static class Product {

        ArrayList<Product> datas = new ArrayList<>();
        private String name;

        public Product() {
        }

        public Product(String name) {
            this.name = name;
        }

        public synchronized void product() {
            try {
                if (datas.size() > 10) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            datas.add(new Product(Thread.currentThread().getName() + "生产"));
            if (datas.size() > 0) {
                this.notify();
            }
        }

        public synchronized void consumer() {
            if (datas.size() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (datas.size() != 0) {
                System.out.println(Thread.currentThread().getName() + " xiaofei :" + datas.remove(0).name);
            }
            if (datas.size() < 10) {
                this.notify();
            }
        }
    }

    //============================================

    //========================================  自己实现一个阻塞队列

    static class TLinkedBlockQueue<T> {
        private ReentrantLock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private Condition notFull = lock.newCondition();
        private static final int maxSize = 16;
        private Queue<T> queue = new LinkedList<>();
        int count = 0;

        class Node<T> {
            private Node next;
            private T data;

            public Node(T t) {
                data = t;
            }
        }

        public void offer(T t) {
            try {
                lock.lock();
                while (count == maxSize) {
                        System.out.println("jinlaile" + Thread.currentThread().getName());
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(t);
                count++;
                if (count > 0) {
                    notEmpty.signal();
                }
            } finally {
                lock.unlock();
            }

        }

        public T take() {
            lock.lock();
            try {

                if (count == 0) {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T poll = queue.poll();
                count--;
                if (count < maxSize) {
                    notFull.signal();
                }
                return poll;
            } finally {
                lock.unlock();
            }
        }
    }


    static class Producter1 implements Runnable {
        private TLinkedBlockQueue blockQueue;

        public Producter1(TLinkedBlockQueue blockQueue) {
            this.blockQueue = blockQueue;
        }

        @Override
        public void run() {
            while (true) { // 一直生产
                String name = Thread.currentThread().getName() + "  生产了 西瓜汁";
                blockQueue.offer(name);
                System.out.println("生产者  :" + name);
            }
        }
    }

    static class Consumer1 implements Runnable {
        private TLinkedBlockQueue blockQueue;

        public Consumer1(TLinkedBlockQueue blockQueue) {
            this.blockQueue = blockQueue;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("消费者  :" + Thread.currentThread().getName() + "消费了" + blockQueue.take());
            }
        }
    }

}

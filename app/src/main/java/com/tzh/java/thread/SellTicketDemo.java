package com.tzh.java.thread;

/**
 * create by tuzanhua on 2020/4/15
 */
public class SellTicketDemo {
//    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask);
        Thread thread2 = new Thread(myTask);
        Thread thread3 = new Thread(myTask);
        Thread thread4 = new Thread(myTask);
        Thread thread5 = new Thread(myTask);
        long time = System.currentTimeMillis();

        System.out.println();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

//        try {
////            countDownLatch.await();
//            System.out.println(System.currentTimeMillis() - time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    //51 5ge
    //45 1个


    //30220  5
    //30213  single
    static class MyTask implements Runnable {

        private int ticket = 300;

        @Override
        public void run() {
            while (true)
                synchronized (this) {
                    if (ticket > 0) {
                        // 如果是比较耗时的操作呢

                        try {
                            Thread.currentThread().sleep(50);//模拟卖票需要一定的时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
//                        try {
//                            Thread.sleep(100);
//                            System.out.println(Thread.currentThread().getName() + "卖出第 :" + ticket + " 张票");
//                            ticket--;
//                            Thread.yield();
//
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        try {
                            Thread.currentThread().sleep(50);//模拟卖票需要一定的时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println(Thread.currentThread().getName() + "关闭窗口");
//                        countDownLatch.countDown();
                        break;
                    }
                }
        }
    }
}

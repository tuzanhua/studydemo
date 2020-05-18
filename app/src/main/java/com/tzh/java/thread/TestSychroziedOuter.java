package com.tzh.java.thread;

/**
 * create by tuzanhua on 2020/4/24
 */
public class TestSychroziedOuter {

    public static void main(String[] args) {

        Demo demo = new Demo();
        new Thread(()->{
           while (true){
               demo.show();
           }
        }).start();

        new Thread(()->{
            while (true){
                demo.show();
            }
        }).start();
    }

   static class Demo {

        int i = 0;

        public void show() {
            synchronized (this) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                }
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "    " + i);
        }

    }
}

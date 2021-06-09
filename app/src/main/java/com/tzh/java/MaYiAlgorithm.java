package com.tzh.java;

public class MaYiAlgorithm {

//    一只蚂蚁，从一口井深X米的井里面往出口爬，每30分钟爬1米，每爬30分钟休息Y分钟，休息的时候，
//    每分钟下滑2厘米，每只蚂蚁的体质不同，需要休息的时间也不同。
//    用java代码写一个方法，可以根据不同的蚂蚁和不同的井，计算爬出井需要的时间

    public static  void main(String[] args) {
        MaYiAlgorithm qingWaAlgorithm = new MaYiAlgorithm();
        int time = qingWaAlgorithm.getTime(2, 10);
        System.out.println("time : " + time);
    }
    public int getTime(float n, int y) {
        if (n == 0 || y >= 50) {
            return -1;
        }
        if (n==1){
            return 30;
        }
        float n1 = n;
        int y1 = y;
        float time = 0;
        while (n1 > 0) {
            if ((n1 - 1) <= 0) {
                time = time + 30 * 1.0f  * n1;
                System.out.println("结束了 :" + time  + "   " + n1);
                n1 = n1 - 1;
            } else {
                time = time + 30 + y;
                n1 = n1 - (1 - (float) (0.02 * y1));
                System.out.println("过程中 :" + time   + "    剩余距离 : " + n1 );
            }
        }
        return (int) time;
    }
}

package javaoop_0226.src.home.scg;

import java.util.ArrayList;


public class Exam5 {
    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        Thread th1 = new Thread(runnable1, "前门");
        Thread th2 = new Thread(runnable1, "后门");
        th1.start();
        th2.start();
    }
}

class Runnable1 implements Runnable {
    int sumQ = 0;   //前门进去的人数
    int sumH = 0;   //后门进去的人数
    int sum = 100;   //总人数
    boolean flag = false;  //判断
//    重写run
    @Override
    public void run() {
        while (!flag) {
            enter();
        }
    }

    synchronized private void enter() {
//        停止循环
        if (sum == 0) {
            flag = true;
            return;
        }
//        休眠
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        获取name
        String threadName = Thread.currentThread().getName();
//        集合
        ArrayList list = new ArrayList();
//        循环添加随机数
        for (int i = 0; i < 7; i++) {
            list.add((int) (33 * Math.random() + 1));
        }
        System.out.println("编号为：" + (100 - sum + 1) + "的员工从" + threadName + "入场！拿到的双色球彩票号码是：" + list.toString());

//        判断线程的名字
        if (threadName.equals("前门")) {
            sumQ++;
        } else if (threadName.equals("后门")) {
            sumH++;
        }

        sum--;

//        显示
        if (sum == 0) {
            System.out.println("前门人数：" + sumQ);
            System.out.println("后门人数：" + sumH);
        }


    }
}

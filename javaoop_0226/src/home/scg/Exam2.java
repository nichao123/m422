package javaoop_0226.src.home.scg;

public class Exam2 {
    public static void main(String[] args) {

        MyRunnable my = new MyRunnable();
        Thread th1 = new Thread(my,"军人");
        Thread th2 = new Thread(my,"学生");
        Thread th3 = new Thread(my,"老年人");
        Thread th4 = new Thread(my,"网上");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
 class MyRunnable implements Runnable {
    //当前的票数
    int count = 30;

    //购买的票数
    int num = 0;

    //    判断是否卖完
    boolean flag = false;

    //        重写run
    @Override
    public void run() {
        while (!flag) {
            sale();
        }
    }

    //同步方法
    synchronized private void sale() {
        //停止循环
        if (count == 0) {
            System.out.println(Thread.currentThread().getName()+"售票口窗口已售罄！！！");
            flag = true;
            return;
        }

//        输出
        System.out.println(Thread.currentThread().getName() + "售票口窗口————>车票号No." + count);

        count--;

    }
}

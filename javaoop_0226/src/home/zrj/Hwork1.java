package javaoop_0226.src.home.zrj;

public class Hwork1 {
    public static void main(String[] args) {
//        练习1：有三个线程T1，T2，T3，编写代码确保它们按顺序执行如图所示：
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is finished ");
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is finished ");
            }
        }, "t2");
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is finished ");
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

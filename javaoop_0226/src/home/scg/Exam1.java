package javaoop_0226.src.home.scg;

public class Exam1 {
    public static void main(String[] args) {
//        线程对象
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        MyThread th3 = new MyThread();

//        改名
        th1.setName("t1");
        th2.setName("t2");
        th3.setName("t3");


//        启动和强制执行
        try {
            th1.start();
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        启动和强制执行
        try {
            th2.start();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        启动和强制执行
        try {
            th3.start();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
 class MyThread extends Thread{
    //        重写run
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is finished");
    }
}

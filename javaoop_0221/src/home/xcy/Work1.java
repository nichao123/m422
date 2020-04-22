package javaoop_0221.src.home.xcy;

public class Work1 {
    //练习1：需求说明:继承Thread类的方式创建线程
    //创建两个子线程，每个线程均输出20次消息数字、“你好”、线程名
    //观察多个线程交替执行的过程


    public static void main(String[] args) {
        MyThread my0 = new MyThread();
        MyThread my1 = new MyThread();
//        my0.setName("Thread-0");
//        my1.setName("Thread-1");
        my0.start();
        my1.start();
    }


}

class MyThread extends Thread {
    //重写方法
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + ".你好，来自线程" + Thread.currentThread().getName());
        }
    }
}

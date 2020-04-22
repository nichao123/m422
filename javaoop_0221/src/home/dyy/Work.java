package javaoop_0221.src.home.dyy;
//练习1：需求说明:继承Thread类的方式创建线程
//        创建两个子线程，每个线程均输出20次消息数字、“你好”、线程名
//        观察多个线程交替执行的过程
public class Work extends Thread{
    public void run(){

//        创建线程均输出20次消息数字、“你好”、线程名
        for (int i = 0; i <20; i++) {
            Thread thread=Thread.currentThread();
            System.out.println((i+1)+".你好，来自线程"+thread.getName());

        }
    }

    public static void main(String[] args) {
        Work thread1=new Work();
        Work thread2=new Work();

        thread1.start();
        thread2.start();

    }
}

package javaoop_0221.src.home.dyy;
//修改上机练习1，要求线程类使用实现Runnable接口的方式创建，并修改测试类
public class Work2  implements Runnable{
    public void run(){

//        创建线程均输出20次消息数字、“你好”、线程名
        for (int i = 0; i <20; i++) {
            Thread thread=Thread.currentThread();
            System.out.println((i+1)+".你好，来自线程"+thread.getName());

        }
    }

    public static void main(String[] args) {
        Work work=new Work();

//        创建两个子线程
        Thread thread1=new Thread(work,"Thread-0");
        Thread thread2=new Thread(work,"Thread-1");
        thread1.start();
        thread2.start();

    }
}

package javaoop_0224.src.home.zrj;

public class Hwork1 {
    public static void main(String[] args) {
//        练习1：线程的优先级
//                需求说明
//        显示主线程、子线程默认优先级
//        创建线程
        TextThread1 th1=new TextThread1();
        Thread th=Thread.currentThread();
        System.out.println("**********显示默认的优先级***********");
        System.out.println("主线程名："+th.getName()+",优先级："+th.getPriority());
        System.out.println("子线程名："+th1.getName()+"，优先级："+th1.getPriority());
//        将主线程设置为最高优先级、子线程设置为最低优先级并显示
        th1.setPriority(Thread.MIN_PRIORITY);
        th.setPriority(Thread.MAX_PRIORITY);
        System.out.println("**********修改默认优先级后***********");
        System.out.println("主线程名："+th.getName()+",优先级："+th.getPriority());
        System.out.println("子线程名："+th1.getName()+"，优先级："+th1.getPriority());
    }
}
//定义线程
class TextThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

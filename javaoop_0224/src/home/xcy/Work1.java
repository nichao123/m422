package javaoop_0224.src.home.xcy;

public class Work1 {
    //练习1：线程的优先级
    //需求说明
    //显示主线程、子线程默认优先级
    //将主线程设置为最高优先级、子线程设置为最低优先级并显示
    public static void main(String[] args) {
        //创建线程对象
        MyRunable my = new MyRunable();

        //线程代理
//        Thread th1 = new Thread(my,"main");

        Thread th1 =Thread.currentThread();
        Thread th2 = new Thread(my);

        System.out.println("显示默认优先级");
        System.out.println("主线程："+th1.getName()+"，优先级："+th1.getPriority());
        System.out.println("子线程："+th2.getName()+"，优先级："+th2.getPriority());

        //设置优先级
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("显示修改后优先级");
        System.out.println("主线程："+th1.getName()+"，优先级："+th1.getPriority());
        System.out.println("子线程："+th2.getName()+"，优先级："+th2.getPriority());


    }
}

class MyRunable implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
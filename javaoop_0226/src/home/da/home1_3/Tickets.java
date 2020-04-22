package javaoop_0226.src.home.da.home1_3;

/**
 * @ClassName Tickets
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/23
 * @Version V1.0
 **/
/*
 * 多窗口卖票系统。多线程
 * 票数为静态的，共享数据
 * synchronized(对象){}代码块中的内容是加锁的，
 * 即当一个线程在使用时，其他线程不可以进入。
 * 使得共享资源数据的安全。
 */
public class Tickets extends Thread {

    static int ticket = 30;//票数共30张

    /**
     * 构造方法
     * @param name 线程名称
     */
    public Tickets(String name) {
        super(name);
    }

    //重写run方法，
    public void run() {
        while (ticket > 0) {
            //注意：这里必须是Tickets.class,而不是this哦！
            synchronized (Tickets.class) {
                if (ticket > 0) {
                    System.out.println(super.getName() + "窗口---->车票号No." + ticket);
                    ticket--;
                } else {
                    System.out.println(super.getName() + "票已售罄！！!");
                }
                try {
                    sleep(100);//睡100毫秒，抛出多线程异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class Test2 {
    public static void main(String[] args) {
        Tickets b1 = new Tickets("军人售票口");
        Tickets b2 = new Tickets("学生售票口");
        Tickets b3 = new Tickets("老年人售票口");
        Tickets b4 = new Tickets("网上售票口");
        b1.start();
        b2.start();
        b3.start();
        b4.start();
    }
}

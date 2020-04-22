package javaoop_0226.src.home.zrj;

public class Hwork4 {
    public static void main(String[] args) {
//        上机1：多线程使用sleep★★★☆☆
//        要求有三个线程：2个学生，1个老师，
//        其中线程学生大白熊准备“睡”1分钟后再开始上课，
//        线程x学生翠花准备“睡”5分钟后再开始上课。
//        老师吉吉国王在输出4句“上课了!”后，
//        “唤醒”了休眠的线程大白熊；
//        线程大白熊被“唤醒”后，负责再“唤醒”休眠的线程翠花。
        Shangke shangke=new Shangke();
        Thread th1=new Thread(shangke);
        System.out.println("老师线程"+"=>"+shangke.teacher.getName());
        System.out.println("学生线程"+"=>"+shangke.bear.getName());
        System.out.println("学生线程"+"=>"+shangke.cuihua.getName());
        shangke.teacher.start();
        shangke.cuihua.start();
        shangke.bear.start();
    }
}
class Shangke implements Runnable{
    Thread teacher,bear,cuihua;

    public Shangke() {
        teacher = new Thread(this,"吉吉老师");
        bear = new Thread(this,"大白熊");
        cuihua = new Thread(this,"翠花");
    }

    @Override
    public void run() {
        if (Thread.currentThread()==cuihua){
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                System.out.println("学生线程"+Thread.currentThread().getName()+"唤醒");
            }
        }
        else if (Thread.currentThread()==bear){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println("学生线程"+Thread.currentThread().getName()+"唤醒");
                cuihua.interrupt();
            }
        }
        else if (Thread.currentThread()==teacher){
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName()+"说：开始上课！");
            }
            bear.interrupt();
        }
    }
}

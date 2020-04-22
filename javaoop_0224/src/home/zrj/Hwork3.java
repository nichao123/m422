package javaoop_0224.src.home.zrj;

public class Hwork3 {
    public static void main(String[] args) {
//        上机1：模拟多人爬山★★★☆☆
//        需求说明
//        每个线程代表一个人可设置每人爬山速度，每爬完100米显示信息；爬到终点时给出相应提示
//                实现思路
//        创建线程类ClimbThread
//        属性：爬100米时长（time），爬多少个100米（num）
//        构造方法完成属性初始化
//        实现run()方法
//                线程休眠模拟爬山中的延时
//        实现测试类Test
//        创建多个线程对象模拟多个人，设置人名、爬100米时长
        ClimbThread ct1=new ClimbThread(500,10);
        ClimbThread ct2=new ClimbThread(1000,8);
        Thread th1=new Thread(ct1,"年轻人");
        Thread th2=new Thread(ct2,"老年人");
        th1.start();
        th2.start();
    }
}
//定义线程
class ClimbThread implements Runnable{
//        属性：爬100米时长（time），爬多少个100米（num）
    private long time;
    private  int num;
    public ClimbThread(long time,int num) {
        this.time = time;
        this.num=num;
    }
    public ClimbThread() {
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"爬了"+((i+1)*100)+"米");
            if (i==num-1){
                System.out.println(Thread.currentThread().getName()+"爬完了");
            }
        }
    }
}

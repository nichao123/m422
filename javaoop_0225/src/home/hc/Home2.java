package javaoop_0225.src.home.hc;

public class Home2 {
    public static void main(String[] args) {
//        练习2：网络购票
//                需求说明
//“桃跑跑”、“张票票”、“黄牛党”共同抢10张票；限“黄牛党”只能抢一张票
        //创建线程对象
        MyRunable5  my = new MyRunable5();

        //线程代理
        Thread th1=new Thread(my,"桃跑跑");
        Thread th2=new Thread(my,"张票票");
        Thread th3=new Thread(my,"黄牛党");

        //启动线程
        th1.start();
        th2.start();
        th3.start();
    }
}
class MyRunable5 implements  Runnable{

    //当前的票数
    int count=10;

    //购买的票数
    int num=0;

    //票的状态
    private boolean flag = false;

    @Override
    public void run() {

        //循环购买
        while (!flag) {
            sale();
            if(Thread.currentThread().getName().equals("黄牛党")){
                return;
            }
        }
    }

    //同步方法
    synchronized private void sale() {
        //停止循环
        if (count == 0) {
            flag=true;
            return;
        }

        num++;
        count--;

        try {
            //休眠
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票，剩余"+count+"张票！");
    }
}
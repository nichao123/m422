package javaoop_0221.src.lesson.org.hlx;



/**
 * @ClassName TestPriority
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestTicket {

    public static void main(String[] args) {
        //创建线程对象
        MyRunable4  my = new MyRunable4();

        //线程代理
        Thread th1=new Thread(my,"徐晨阳");
        Thread th2=new Thread(my,"懒洋洋");
        Thread th3=new Thread(my,"黄牛");

        //启动线程
        th1.start();
        th2.start();
        th3.start();

    }
}

class MyRunable4 implements  Runnable{

   //当前的票数
   int count=10;

    //购买的票数
    int num=0;

    @Override
    public void run() {

        //循环购买
        while(true){

            //停止循环
            if (count == 0) {
                break;
            }

             num++;
             count--;

            try {
                //休眠
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()
                    +"抢到第"+num+"张票，剩余"+count+"张票！");
        }

    }
}

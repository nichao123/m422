package javaoop_0221.src.lesson.org.hlx;



/**
 * @ClassName TestPriority
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestSleep {

    public static void main(String[] args) {
        //创建线程对象
        MyRunable1  my = new MyRunable1();

        //线程代理
        Thread th1=new Thread(my);
        Thread th2=new Thread(my);


        //启动线程
        th1.start();
        th2.start();

    }
}

class MyRunable1 implements  Runnable{


    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
                Thread.sleep(1000);   //1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

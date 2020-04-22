package javaoop_0221.src.lesson.org.hlx;



/**
 * @ClassName TestPriority
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestYied {

    public static void main(String[] args) {
        //创建线程对象
        MyRunable3  my = new MyRunable3();

        //线程代理
        Thread th1=new Thread(my);
        Thread th2=new Thread(my);


        //启动线程
        th1.start();
        th2.start();

    }
}

class MyRunable3 implements  Runnable{


    @Override
    public void run() {
        for (int i = 1; i <6 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);

            if (i == 2) {
                System.out.print("线程礼让：");
                Thread.yield();
            }
        }
    }
}

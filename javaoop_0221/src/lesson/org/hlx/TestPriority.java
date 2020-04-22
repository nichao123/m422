package javaoop_0221.src.lesson.org.hlx;



/**
 * @ClassName TestPriority
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestPriority {

    public static void main(String[] args) {
        //创建线程对象
        MyRunable  my = new MyRunable();

        //线程代理
        Thread th1=new Thread(my);
        Thread th2=new Thread(my);

        //设置优先级
        th2.setPriority(Thread.MAX_PRIORITY);

        th1.setPriority(Thread.MIN_PRIORITY);

        //启动线程
        th1.start();
        th2.start();

    }
}

class MyRunable implements  Runnable{


    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}

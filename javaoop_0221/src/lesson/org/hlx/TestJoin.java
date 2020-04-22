package javaoop_0221.src.lesson.org.hlx;



/**
 * @ClassName TestPriority
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestJoin {

    public static void main(String[] args) {
        //创建线程对象
        MyRunable2  my = new MyRunable2();

        //线程代理
        Thread th1=new Thread(my);

        //启动线程
        th1.start();

        //主线程
        for (int i = 0; i <10 ; i++) {

           //当i=5时，子线程走完，主线程再走
            if (i == 5) {
                try {
                    th1.join();  //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i);

        }


    }
}

class MyRunable2 implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}

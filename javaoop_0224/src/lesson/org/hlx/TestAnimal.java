package javaoop_0224.src.lesson.org.hlx;

/**
 * @ClassName TestAnimal
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/24
 * @Version V1.0
 **/
public class TestAnimal {

    public static void main(String[] args) {

        //获得当前线程
        Thread th1 =Thread.currentThread();
        System.out.println("线程刚开始运行的线程名:"+th1.getName());
        System.out.println("线程状态:"+th1.getState());
        System.out.println("当前线程活动数量："+Thread.activeCount());

        Animal animal =new Animal();
        System.out.println("兔子线程状态:"+animal.rabbit.getState());
        System.out.println("乌龟线程状态:"+animal.tortoise.getState());

        animal.rabbit.start();
        System.out.println("兔子线程状态:"+animal.rabbit.getState());
        animal.tortoise.start();
        System.out.println("乌龟线程状态:"+animal.tortoise.getState());

        System.out.println("当前线程活动数量："+Thread.activeCount());
    }
}

/**
 * 实现线程接口
 */
class Animal implements  Runnable{
    //线程对象
    Thread rabbit,tortoise;

    /**
     * 初始化小兔子，乌龟
     */
    public Animal() {
        rabbit =new Thread(this,"兔子");
        tortoise =new Thread(this,"乌龟");
    }

    @Override
    public void run() {
        //判断当前线程是不是小兔子
        if (Thread.currentThread() == rabbit) {
            System.out.println("兔子呼呼大睡....");
            //2小时
            try {
                Thread.sleep(1000*60*2*60);
            } catch (InterruptedException e) { //中断异常
                e.printStackTrace();
                System.out.println("兔子被叫醒....");
                System.out.println("兔子开始跑....");
            }
        }else if (Thread.currentThread()==tortoise){
            System.out.println("乌龟在大喊，跑步。。。");
            rabbit.interrupt(); //中断小兔子
            System.out.println("乌龟到达终点.");
        }

    }
}
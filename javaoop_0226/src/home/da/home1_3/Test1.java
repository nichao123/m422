package javaoop_0226.src.home.da.home1_3;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/23
 * @Version V1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        method01();

    }

    /**
     * 第一种实现方式，顺序写死在线程代码的内部了，有时候不方便
     */
    private static void method01() {
        Thread t1 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("t1 is finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 is finished");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 is finished");
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }


}

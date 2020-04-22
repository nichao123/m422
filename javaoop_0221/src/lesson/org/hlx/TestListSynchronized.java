package javaoop_0221.src.lesson.org.hlx;

import java.util.*;

/**
 * @ClassName TestList
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestListSynchronized {
    //集合
    static  ArrayList<Object> list0 = new ArrayList<>();

    //解决1:使用Collections.synchronizedList。它会自动将我们的list方法进行改变，最后返回给我们一个加锁了List
    static List<Object> list = Collections.synchronizedList(list0);

    //解决2：完整能解决
//    static Vector<Object> list = new Vector<Object>();

    public static void main(String[] args) {


//        Hashtable
////       HashMap

//        StringBuilder
//         StringBuffer

         //线程数组10
       Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            //存放线程
            threads[i] = new ArrayListThread2();
            //启动线程
            threads[i].start();
        }
        
        //
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();// 等待该线程终止
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // 输出list中的对象元素
        for (int i = 0; i < threads.length; i++) {
            System.out.println(TestList.list.get(i));
        }


    }
}

//线程类
 class ArrayListThread2 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);   //休眠1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 增加元素
        //添加当前线程到集合中
        TestList.list.add(Thread.currentThread().getName());
    }

}
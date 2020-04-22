package javaoop_0221.src.lesson.org.hlx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * @ClassName TestList
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestList {
    //集合
    static  ArrayList<Object> list = new ArrayList<>();

    public static void main(String[] args) {
   //        ArrayList     public  boolean add(E e)

         //线程数组10
       Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            //存放线程
            threads[i] = new ArrayListThread();
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
        for (int i = 0; i < 100; i++) {
            System.out.println(TestList.list.get(i));
        }


    }
}

//线程类
 class ArrayListThread extends Thread {

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
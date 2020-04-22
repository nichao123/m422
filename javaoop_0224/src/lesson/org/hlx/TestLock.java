package javaoop_0224.src.lesson.org.hlx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestLock
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/24
 * @Version V1.0
 **/
public class TestLock {

    public static void main(String[] args) {
        getLock("helloworld!");
    }


    public static void getLock(String str){
        // new一个锁对象，注意此处必须声明成类对象，保持只有一把锁,ReentrantLock是Lock的唯一实现类
        Lock lock =new ReentrantLock();

        try {
            //上锁
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "得到了锁，正在读取文件……");
            //按一个一个字符读取
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
            System.out.println("文件读取完毕！");
        }finally {
//            System.out.println(Thread.currentThread().getName() + "释放了锁！");
            //释放锁
             lock.unlock();
        }


    }
}

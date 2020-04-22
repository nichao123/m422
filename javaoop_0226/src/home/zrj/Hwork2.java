package javaoop_0226.src.home.zrj;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.BufferedWriter;

public class Hwork2 {
    public static void main(String[] args) {
//        练习2：购票窗口实现票数同步
//        需求：车票总共30张，有（军人，学生，老年人，网上）售票口来购买车票.如图显示：
        Buy bb=new Buy();
        Thread th1=new Thread(bb,"学生");
        Thread th2=new Thread(bb,"军人");
        Thread th3=new Thread(bb,"老人");
        Thread th4=new Thread(bb,"网上");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
class Buy implements Runnable{
    private int nums=30;
    @Override
    public synchronized void run() {
        while (true){
            if (nums==0){
                System.out.println(Thread.currentThread().getName()+"售票窗口票已售罄");
                break;
            }
            nums--;
            System.out.println(Thread.currentThread().getName()+"售票窗口--->车票号No."+(nums+1));
        }
    }
}
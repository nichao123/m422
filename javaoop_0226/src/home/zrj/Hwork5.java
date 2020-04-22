package javaoop_0226.src.home.zrj;

import java.util.Arrays;

public class Hwork5 {
    public static void main(String[] args) {
//        上机2：多线程使用sleep★★★★☆
//        某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多线程模拟年会入场过程.
//        创建两个线程设置线程名称分别为“前门”，“后门”
//        并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
        Kaihui kaihui=new Kaihui();
        Thread th1=new Thread(kaihui);
        kaihui.qianmen.start();
        kaihui.houmen.start();
//        th1.start();
    }
}
class Kaihui implements Runnable{
    Thread qianmen,houmen;
    int countQ=0;
    int countH=0;
   static int count=0;
    public Kaihui() {
        qianmen=new Thread(this,"前门");
        houmen=new Thread(this,"后门");
    }
    @Override
    public void run() {
         do {
             if (Thread.currentThread() == qianmen) {
                 countQ++;
                 count++;
                 System.out.println("编号为" + count + "的员工 从" + Thread.currentThread().getName() + "入场！拿到的双色球彩票号码是：" + Arrays.toString( caipiao()));
             } else if (Thread.currentThread() == houmen) {
                 countH++;
                 count++;
                 System.out.println("编号为" + count + "的员工 从" + Thread.currentThread().getName() + "入场！拿到的双色球彩票号码是：" +Arrays.toString( caipiao()));
             }
         }while (count<100);

         //判断
         if(count==100) {
             System.out.println("前门人数：" + countQ);
             System.out.println("后门人数：" + countH);
         }
    }
    public int[] caipiao(){
        int nums[]=new int[7];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=(int)(Math.random()*33+1);
        }
        return nums;
    }

}

package javaoop_0225.src.home.lly;

public class Home03 {
    public static void main(String[] args) {

        MyRunnable2 my=new MyRunnable2();
        Thread thread1=new Thread(my,"抽奖箱1");
        Thread thread2=new Thread(my,"抽奖箱2");
        thread1.start();
        thread2.start();




    }
}
class MyRunnable2 implements Runnable{
    int[] arr ={600, 88, 20, 50, 100, 200, 500, 900, 5, 1000, 2000,60,300};
    //        记录数据
    int count=arr.length;
    //        下标

    //        判断是否抽过
    boolean[]flag=new boolean[arr.length];

    boolean flags;



    @Override
    public  void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (true){
        for (int i = 0; i <arr.length ; i++) {
            if (count>0){
                int index=(int)(Math.random()*arr.length);
                //        数据
                int get=arr[index];
                if (flag[index]!=true){
                    flag[index]=true;
                    System.out.println(Thread.currentThread().getName()+"又产生了一个"+get+"元大奖");
                    count--;
//                    System.out.println(count);
//                    if (count<=0){
//                        flags=false;
//                        System.out.println("程序退出!");
//                    }
                }
            }
        }

//
//
        }

    }
//    }





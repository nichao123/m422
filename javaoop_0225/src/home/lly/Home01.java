package javaoop_0225.src.home.lly;

public class Home01 {
    public static void main(String[] args) {
        MyRunnable my=new MyRunnable();
        //循环
        for (int i = 1; i <11 ; i++) {
            Thread thread1=new Thread(my,i+"号");
            thread1.start();
        }

    }
}

class MyRunnable implements Runnable{
//    记录接力跑的总路程
    private int koliamter=0;
    @Override
    public void run() {
        running();

    }
   synchronized public void running(){
        if (koliamter<1000){
            System.out.println(Thread.currentThread().getName()+"选手拿到接力棒！");
            for (int i = 0; i <10 ; i++) {
//                int total=(i+1)*10;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"选手跑了"+(i+1)*10+"米");
                koliamter+=10;
//                System.out.println(koliamter);
                if (koliamter==1000){
                    System.out.println("比赛结束!");
                }
            }
        }
    }
}

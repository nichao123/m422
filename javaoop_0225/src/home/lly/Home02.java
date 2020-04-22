package javaoop_0225.src.home.lly;

public class Home02 {
    public static void main(String[] args) {
        MyRunnable1 my=new MyRunnable1();
        Thread thread1=new Thread(my,"桃跑跑");
        Thread thread2=new Thread(my,"张票票");
        Thread thread3=new Thread(my,"黄牛党");

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
class MyRunnable1 implements Runnable{
//      买的票数，抢的票数
        int buy_number=0;
//        剩余的票数
        int sale_number=10;
    @Override
    public void run() {

           shopcards();
    }
    public synchronized void shopcards(){
        while (sale_number!=0){
            buy_number++;
            sale_number--;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //抢到1张票就结束
           if (Thread.currentThread().getName().equals("黄牛党")){
               System.out.println(Thread.currentThread().getName()+"抢到了第"+buy_number+"剩余"+sale_number+"张票");
               break;
           }else{
               System.out.println(Thread.currentThread().getName()+"抢到了第"+buy_number+"剩余"+sale_number+"张票");
           }

        }
    }
}

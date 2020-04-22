public class H2 {
    public static void main(String[] args) {
        //创建线程对象
        MyRunable  my = new MyRunable();

        //线程代理
        Thread th1=new Thread(my,"桃跑跑");
        Thread th2=new Thread(my,"张票票");
        Thread th3=new Thread(my,"黄牛党");
        th1.start();
        th2.start();
        th3.start();

    }
}
class MyRunable implements  Runnable{
    int count=10;
    int num=0;
    boolean flag=false;

    @Override
    public void run() {
        while(true){
            if (!sale()) {
                break;
            }

        }

    }
    synchronized boolean sale(){
        if (count<=0){
            return false;
        }
        num++;
        count--;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                +"抢到第"+num+"张票，剩余"+count+"张票！");
        if(Thread.currentThread().getName().equals("黄牛党")) {
            return false;
        }
        return true;
    }
}

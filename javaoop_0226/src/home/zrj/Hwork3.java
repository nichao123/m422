package javaoop_0226.src.home.zrj;

public class Hwork3 {
    public static void main(String[] args) {
//        练习3：编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，生产10台电视机，一边生产一边消费。★★★★☆
//        说明：
//          （1）有一个具有一定容量的存放产品的仓库。
//          （2）生产者不断生产产品，产品保存在仓库中（产品入仓）。
//          （3）消费者不断购买仓库中的产品（产品出仓）。
//          （4）只有仓库有空间，生产者才能生产，否则只能等待。
//          （5）只有仓库存在产品，消费者才能购买（消费）。
//        在生产者与消费者模型中，涉及4个概念：产品、仓库、生产者和消费者，关键是后3个：
//          （1）仓库，是临界资源，仓库的产品不能同时入仓和出仓。
//          （2）生产者线程：工人。
//          （3）消费者线程：购买产品的人。
        Cangku cangku=new Cangku();
        Thread th1 = new Thread(new Gongren(cangku), "工人");
        Thread th2 = new Thread(new Xiaofei(cangku), "消费者");
        th1.start();
        th2.start();
    }
}
//          （1）有一个具有一定容量的存放产品的仓库。
class Cangku{
//    产品名称
    private String name;
//    标记
    private boolean flag=true;
    private int num=0;
//    生产
    public synchronized void Shengchan(String name){
//        产品数量如果处于1-4之间则可以销售
        if (num>=4&&!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产:"+name+" \t 产品总数："+(num+1));
        this.name=name;
//        唤醒消费者
        notify();
//        更改产品状态
        flag=false;
        num++;
    }
//    销售
    public synchronized void Sale(){
        if (num<4&&flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("购买："+name+" \t 产品数量："+(num-1));
//        唤醒生产
        notify();
//        更改产品状态
        flag=true;
        num--;
    }
}
//工人线程
class Gongren implements Runnable{
    private Cangku cangku;
    public Gongren(Cangku cangku) {
        this.cangku = cangku;
    }
    @Override
    public void run() {
//        生产商品
        while (true) {
            cangku.Shengchan("产品" + ((int) (Math.random() * 4) + 1));
        }
    }
}

//消费者线程
class Xiaofei implements Runnable{
    private Cangku cangku;
    public Xiaofei(Cangku cangku) {
        this.cangku = cangku;
    }
    @Override
    public void run() {
        while (true){
            cangku.Sale();
        }
    }
}


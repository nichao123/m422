public class H3 {
    public static void main(String[] args) {
        Shop shop=new Shop();
        Proudce p=new Proudce(shop);
        Consumer c=new Consumer(shop);
        Thread th1 = new Thread(p, "生产编号1");
        Thread th2 = new Thread(p, "生产编号2");
        Thread th3 = new Thread(p, "生产编号3");
        Thread th4 = new Thread(p, "生产编号4");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        Thread th5 = new Thread(c, "消费编号1");
        Thread th6 = new Thread(c, "消费编号2");
        Thread th7 = new Thread(c, "消费编号3");
        Thread th8 = new Thread(c, "消费编号4");
        th5.start();
        th6.start();
        th7.start();
        th8.start();
    }


}

class Shop {

    private int count;

    public final int MAX_COUNT = 10;

    public synchronized void push () {
        while(count >= MAX_COUNT) {
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count ++;
        System.out.println(Thread.currentThread().getName() + "电视机，当前库存为：" + count);
        notifyAll();
    }

    public synchronized void take () {

        while(count <= 0) {
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        System.out.println(Thread.currentThread().getName() + "电视机，当前库存为：" + count);
        notifyAll();
    }

}
//生产者
 class Proudce implements Runnable {

    private Shop shop;

    public Proudce(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true) {
            shop.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
//消费者
 class Consumer implements Runnable {

    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true) {
            shop.take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


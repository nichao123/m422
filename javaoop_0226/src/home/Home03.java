package javaoop_0226.src.home;

public class Home03 {
    public static void main(String[] args) {
        CCTV cctv = new CCTV();

        Producer producer = new Producer(cctv);
        Consumer consumer = new Consumer(cctv);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();


    }
}

//生产者
class Producer implements Runnable {
    private CCTV cctv;


    public Producer(CCTV cctv) {
        this.cctv = cctv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                cctv.product("家具电视机");
            } else {
                cctv.product("液晶电视机");
            }
        }
    }
}


//消费者
class Consumer implements Runnable {
    //
    private CCTV cctv;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cctv.consumer();
        }
    }

    public Consumer(CCTV cctv) {
        this.cctv = cctv;
    }
}

//两者共同的产品
class CCTV {
    private String name;
    //      产品编号
    private int no;
    //      库存量最大为4
    private int count;
    //      生产总数
    private int total = 10;

    //标记: true:生产，消费者等待，生产者完毕后通知消费者;
    //标记: false:消费，生产者等待，消费者完毕后通知生产者;
    private boolean flag = true;

    //      生产者生产
    public synchronized void product(String name) {
        if (total == 0) {
            return;
        } else if (count >= 4) {
            if (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//           生产
        try {
            Thread.sleep(500);
            count++;
            no++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产编号" + no + name + "," + "当前库存数:" + count);


        this.name = name;

//           通知消费者消费
        notify();

        flag = false;


    }

    public synchronized void consumer() {
        if (total == 0 && count == 0) {
            return;
        } else if (count <= 0) {
            if (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //消费
        try {
            Thread.sleep(500);
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费编号" + no + name + "," + "当前库存数:" + count);

//           消费

//           通知生产者生产
        notify();

        flag = true;

    }

}
